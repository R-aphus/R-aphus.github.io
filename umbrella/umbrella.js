function doGet(e) {
  const timestamp = (new Date()).getTime() / 1000;
  const p = e.parameter;
  const endpoint = "https://api.openweathermap.org/data/2.5/forecast";
  const appid = "d1c78d7630a66a0281cee9583cff3a71";
  const response = UrlFetchApp.fetch(endpoint + "?lat=" + p.lat + "&lon=" + p.lon + "&appid=" + appid).getContentText("UTF-8");
  const json = JSON.parse(response);
  var weather = "";
  var rain = 0;
  var snow = 0;
  var max_rain = 0;
  var max_snow = 0;
  const dt = timestamp + 60 * 60 * 18;
  for (var i in json.list) {
      if (json.list[i].dt > dt) break;
      try {
          rain = json.list[i].rain['3h'];
          if (!isNaN(rain) && rain > max_rain) max_rain = rain;
      } catch(e) {}
      try {
          snow = json.list[i].snow['3h'];
          if (!isNaN(snow) && snow > max_snow) max_snow = snow;
      } catch(e) {}
  }
  if (max_rain >= 0.5 * 3.0 || max_snow > 0.1) {
    weather = "rainy";
  } else {
    weather = "sunny";
  }

  const sheet = SpreadsheetApp.openById('1tSY9Z7-wKvVjPZ2URA5FfjJGjbrkZNf3XXViVWPHLP0');
  const LastRow = sheet.getLastRow();
  sheet.getRange(LastRow, 0).setValue(timestamp);
  sheet.getRange(LastRow, 1).setValue(p.ip);
  try {
    sheet.getRange(LastRow, 2).setValue(p.lat);
    sheet.getRange(LastRow, 3).setValue(p.lon);
    sheet.getRange(LastRow, 4).setValue(p.ac);
    sheet.getRange(LastRow, 5).setValue(p.tm);
  } catch(e){}

  const result = {
    "weather": weather,
    "timestamp": timestamp
  }
  return JSON.stringify(result);
}