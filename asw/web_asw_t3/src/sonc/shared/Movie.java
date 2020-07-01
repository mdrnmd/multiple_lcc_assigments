package sonc.shared;

import java.io.Serializable;
import java.util.*;

public class Movie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Movie(){
		
	}
	
	List<Movie.Frame> frames = new ArrayList<>(); 
	
	public void newFrame() {
		frames.add(new Frame());
	}
	
	public void addOblong(int x, int y, float heading, int size, java.lang.String color) {
		if (frames.isEmpty())
			throw new java.lang.IllegalStateException();
		else
			frames.get(0).oblongs.add(new Oblong(x,y,heading,size,color));
	}
	
	public void addScore(java.lang.String name, int points, int status) {
		if(frames.isEmpty())
			throw new java.lang.IllegalStateException();
		else
			frames.get(0).scores.add(new Score(name, points,status));
	}
	
	public List<Movie.Frame> getFrames() {
		return this.frames;
	}
	

	public class Score extends Movie {
		
		java.lang.String name;
		int points;
		int status;
		
		public Score(String name, int points, int status) {
			super();
			this.name = name;
			this.points = points;
			this.status = status;
		}
		
		public java.lang.String getName() {
			return this.name;
		}
		
		public int getPoints() {
			return this.points;
		}
		
		public int getStatus() {
			return this.status;
		}		
	}

	public class Oblong extends Movie {
		
		int x;
		int y;
		float heading;
		int size;
		java.lang.String color;
		
		public Oblong(int x, int y, float heading, int size, String color) {
			super();
			this.x = x;
			this.y = y;
			this.heading = heading;
			this.size = size;
			this.color = color;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		public float getHeading() {
			return this.heading;
		}
		
		public int getSize() {
			return this.size;
		}
		
		public java.lang.String getColor() {
			return this.color;
		}
	}

	public class Frame extends Movie {
		
		java.util.List<Movie.Oblong> oblongs = new java.util.ArrayList<>();
		java.util.List<Movie.Score> scores = new java.util.ArrayList<>();
		
		public java.util.List<Movie.Oblong> getOblongs() {
			return this.oblongs;
		}
		
		public java.util.List<Movie.Score> getScores() {
			return this.scores;
		}		
	}

}