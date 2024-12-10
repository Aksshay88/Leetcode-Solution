import pandas as pd

def pivotTable(weather: pd.DataFrame) -> pd.DataFrame:
   df = weather.pivot(index = "month", columns = "city", values = 'temperature')
   return df