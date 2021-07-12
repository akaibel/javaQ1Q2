package _test.backtracking;


class BacktrackingMagischesQuadrat{

	private int[][] quadrat;

	BacktrackingMagischesQuadrat(){
		quadrat = new int[3][3];
		initialisiere();
	}

	public void initialisiere(){
		for ( int y=0 ; y < 3 ; y++ ) {
			for ( int x=0 ; x < 3 ; x++ ) {
				quadrat[x][y] = 0;
			} 
		}
	}

	public void findeLoesung(){
		findeLoesung(0);
		System.out.println("*** Loesung: ***");
		this.ausgeben();
	}
	
	public boolean findeLoesung(int pStelle){
		ausgeben();
		//TODO
		
		// x: Spaltennummer (0..2); 
		// y: Zeilennummer(0..2)
		int x = pStelle % 3;
		int y = pStelle / 3;
		//TODO
		return false;
	}
	
	public boolean esGibtDoppelte(){
		boolean[] dabei = new boolean[3*3+1];
		for ( int y=0 ; y < 3 ; y++ ) {
			for ( int x=0 ; x < 3 ; x++ ) {
				int index = quadrat[x][y];
				if(index != 0 && dabei[index]){
					return true;
				}
				dabei[index] = true;
			} 
		}
		return false;
	}

	public boolean magisch(){
		// auf Nullen testen
		for(int x=0; x<3; x++){
			for(int y=0; y<3; y++){
				if(quadrat[x][y] == 0){
					return false;
				}
			}
		}
		if(esGibtDoppelte()){
			return false;
		}
		// Summen testen
		int s=0, t=0;
		// 1. Diagonale
		for ( int x=0 ; x < 3 ; x++ ) s+=quadrat[x][x];
		//2. Diagonale
		for ( int x=0 ; x < 3 ; x++ ) t+=quadrat[3-x-1][x];
		if (t != s) return false;
		// Zeilen
		for ( int y=0 ; y < 3 ; y++ ) {
			int k=0;
			for ( int x=0 ; x < 3 ; x++ ) {
				k += quadrat[x][y];
			}
			if (k != s) return false;
		}
		//Spalten
		for ( int x=0 ; x < 3 ; x++ ) {
			int k=0;
			for ( int y=0 ; y < 3 ; y++ ) {
				k += quadrat[x][y];
			}
			if (k != s) return false;
		}
		System.out.println("*** It's magic!!! ***");
		return true;
	}

	public void ausgeben(){
		for ( int y=0 ; y < 3 ; y++ ) {
			for ( int x=0 ; x < 3 ; x++ ) {
				System.out.print(quadrat[x][y]);
			} 
			System.out.print(" ");
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		BacktrackingMagischesQuadrat mq = new BacktrackingMagischesQuadrat();
		mq.findeLoesung();
	}
}