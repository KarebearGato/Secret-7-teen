public class Levels{
	private int level_Num;
	
	public Levels(int level_Num){
		this.level_Num=level_Num;
	}
	
	public boolean play(){
		switch (level_Num){
			case 1:
				return playLevel1();
			case 2:
				return playLevel2();
			case 3:
				return playLevel3();
			case 4:
				return playLevel4();
			case 5:
				return playLevel5();
			default:
			return false;
		}
	}
	
	private boolean playLevel1() {
        System.out.println("Level 1: Collect 5 items. Type 'collect' to collect an item.");
        int collectedItems = 0;
        while (collectedItems < 5) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("collect")) {
                collectedItems++;
                System.out.println("Collected item " + collectedItems);
            }
        }
        return true;
	}
	
	private boolean playLevel2() {
        System.out.println("Level 2: Collect 4 items. Type 'collect' to collect an item.");
        int collectedItems = 0;
        while (collectedItems < 4) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("collect")) {
                collectedItems++;
                System.out.println("Collected item " + collectedItems);
            }
        }
        return true;
    }
	
	
	private boolean playLevel3() {
        System.out.println("Level 3: Collect 3 items. Type 'collect' to collect an item.");
        int collectedItems = 0;
        while (collectedItems < 3) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("collect")) {
                collectedItems++;
                System.out.println("Collected item " + collectedItems);
            }
        }
        return true;
    }
	
	
	private boolean playLevel4() {
        System.out.println("Level 4: Collect 3 items and defeat 1 monster. Type 'collect' to collect an item.");
        int collectedItems = 0;
        while (collectedItems < 3) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("collect")) {
                collectedItems++;
                System.out.println("Collected item " + collectedItems);
            }
        }
        return true; 
    }
	
	
	
	private boolean playLevel5() {
        System.out.println("Level 5: Collect 5 items and defeat 2 monsters. Type 'collect' to collect an item.");
        int collectedItems = 0;
        while (collectedItems < 5) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("collect")) {
                collectedItems++;
                System.out.println("Collected item " + collectedItems);
            }
        }
        return true;
    }
	
	
}
	
	

	