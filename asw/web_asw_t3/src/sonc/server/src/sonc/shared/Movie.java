package sonc.server.src.sonc.shared;

import java.util.ArrayList;
import java.util.List;

public class Movie extends java.lang.Object {

	List<Frame> frames = new ArrayList<Frame>();
	int currentFrame = -1;
		
	public static class Score {
		String name;
		int points, status;

		public Score(String name, int points, int status) {
			super();
			this.name = name;
			this.points = points;
			this.status = status;
		}

		public String getName() {
			return name;
		}

		public int getPoints() {
			return points;
		}

		public int getStatus() {
			return status;
		}
	}

	public static class Oblong {
		String color;
		float heading;
		int	size;
		int	x,y;

		public Oblong(int x, int y, float heading, int size, String color) {
			super();
			this.x = x;
			this.y = y;
			this.heading = heading;
			this.size = size;
			this.color = color;
		}

		public String getColor() {
			return color;
		}

		public float getHeading() {
			return heading;
		}

		public int getSize() {
			return size;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	public static class Frame {
		List<Oblong> oblongs = new ArrayList<>();
		List<Score> scores = new ArrayList<>(); 

		public Frame() {
			super();
			this.oblongs = new ArrayList<Movie.Oblong>(); 
			this.scores = new ArrayList<Movie.Score>();
		}

		public List<Oblong> getOblongs() {
			return oblongs;
		}

		public List<Score> getScores() {
			return scores;
		}
	}

	// Main Class
	public Movie() {
	}
	
	public void newFrame() {
		currentFrame++;
		Frame paint = new Frame();
		frames.add(paint);
	}
	
	public void addOblong(int x, int y, float heading, int size, String color)
			throws IllegalStateException {
		//System.out.printf(frames.size());
		if(frames.size() == 0) {
			throw new IllegalStateException("Cannot add a rect before creating a frame");
		}
		else
			frames.get(currentFrame).oblongs.add(new Oblong(x,y,heading, size, color));
	}

	public void addScore(String name, int points, int status) 
			throws IllegalStateException {
		if(frames.size() == 0)
			throw new IllegalStateException("create frame firt");
		else
			frames.get(currentFrame).scores.add(new Score(name, points, status));
	}

	public List<Frame> getFrames() {
		return frames;
	}
}

