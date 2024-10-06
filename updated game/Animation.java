import java.awt.Image;
import java.util.ArrayList;

public class Animation {
	private ArrayList<OneScene> scenes;	//List to hold he scenes of the animation
	private int sceneIndex;				//Index of the current scene
	private long movieTime;				//Time elapsed in the animation
	private long totalTime;				//Total time of the animation
	
	private Animation(){
		scenes = new ArrayList();
		totalTime = 0;
		start();
	}//Constructor
	
	public synchronized void addScene(Image i, long t){
		totalTime += t;
		scenes.add(new OneScene(i, totalTime));
	}//Method to add a new scene to the animation
	
	public synchronized void start(){
		movieTime = 0;
		sceneIndex = 0;
	}//Method to reset the animation to the start

	public synchronized void update(long timePassed){
		if(scenes.size() > 1){			//Only updates if there are multiple scenes
			movieTime += timePassed;	//Increments the movie time

			if(movieTime >= totalTime){	//Resets to the start if movieTime exceeds totalTime
				movieTime = 0;			//Reset the movieTime
				sceneIndex = 0;			//Resets to the first scen e of the animation
			}

			//Advances to the next scene if the movieTime exceeds the end time of the current scene
			while(sceneIndex < scenes.size() - 1 && movieTime > getScene(sceneIndex + 1).endTime){
				sceneIndex++; //Moving to next scene 
			}
		}
	}//Method to update the animation state based on the time passed

	public synchronized OneScene getScene(int index){
		return scenes.get(index); //Returns the scene at the given index
	}//Method to get a specific scene based on its index

	public synchronized Image getCurrentImage(){
		return getScene(sceneIndex).image; //Returns the image of the current state
	}//Method to get the current image being displayed

	private class OneScene{
		Image image;	//The image of the scene
		long endTime;	//The end time of this scene 

		OneScene(Image image, long endTime){
			this.image = image; //Sets the image
			this.endTime = endTime; //Sets the end time
		}//Constructor
	}//Class OneScene to represent a single scene in the animation
}























