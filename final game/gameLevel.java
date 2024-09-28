public class gameLevel{
	private int currentLevel;
	
	public gameLevel(){
		this.curentLevel=1;
	}
	
	public void start(){
		while(currentLevel<=5){
			System.out.println("Starting level "+currentLevel+"...");
			Level level=new Level(currentLevel);
			boolean CompletedLev=level.play();
			
			if(CompletedLev){
				currentLevel++;
			}
			else{
				System.out.println("Game Over!");
				break;
			}
		}
		if (currentLevel>5){
			System.out.println("Congratulations! Youve won");
		}
	}
}