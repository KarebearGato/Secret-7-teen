import java.awt.Image;
import java.util.ArrayList;

public class Animation {
	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;
	
	private Animation(){
		scenes=new ArrayList();
		totalTime=0;
		start();
		
	}
	
	public synchronized void addScene(Image i, long t){
		totalTime+=t;
		scenes.add(new oneScene(i, totalTime));
		
	}
	
	public synchronized void start(){
		movieTime=0;
		sceneIndex=0;
	}

	public synchronized void update(long timePassed){
		if(scenes.size()>1){
			movieTime+=timePassed;
			if(movieTime>=totalTime){
				movieTime=0;
				sceneIndex=0;
			}
			while (movieTime>getScene(sceneIndex).endTime){
				sceneIndex++;
			}
		}
	}
}