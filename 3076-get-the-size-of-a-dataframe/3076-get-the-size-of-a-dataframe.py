import pandas as pd

def getDataframeSize(players: pd.DataFrame) -> List[int]:
    [num_rows,num_col] = players.shape 
    return [num_rows , num_col]