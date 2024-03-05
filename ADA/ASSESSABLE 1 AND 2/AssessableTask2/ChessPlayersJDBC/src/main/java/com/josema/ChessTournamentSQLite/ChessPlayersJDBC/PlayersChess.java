package com.josema.ChessTournamentSQLite.ChessPlayersJDBC;
public class PlayersChess {
	private String stId;
	private String stName;
	private String stCountry;
	private float[] arScore = new float[3];
	
	public PlayersChess(String stId, String stName, String stCountry, float[] arScore){
		this.stId = stId;
		this.stName = stName;
		this.stCountry = stCountry;
		this.arScore = arScore;
	}

	public String getStId() {
		return stId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStCountry() {
		return stCountry;
	}

	public void setStCountry(String stCountry) {
		this.stCountry = stCountry;
	}

	public float[] getArScore() {
		return arScore;
	}

	public void setArScore(float[] arScore) {
		this.arScore = arScore;
	}

	@Override
	public String toString() {
		return "'" + stId + "', '" + stName + "', '" + stCountry + "', " + arScore[0] + ", " + arScore[1] + ", " + arScore[2];
	}	
}