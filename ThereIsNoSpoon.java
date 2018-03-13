import java.util.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        String outline = "" ; // Outline string
        
        Character[][] matrix = new Character[height][width]; 
        
        // Store nodes into a 2D array
        for (int r = 0; r < height; r++) {
            String line = in.nextLine(); 
            for(int c = 0; c< width; c++){
                matrix[r][c] = line.charAt(c) ;
            }
        }
        
        for (int r = 0; r < height; r++) {
            for(int c = 0; c< width; c++){
                
                // Bools to store if right and bottom neighbours is found
                boolean foundR = false ; 
                boolean foundB = false; 
                
                if(matrix[r][c] =='0'){
                     outline = c +" "+r ; 

                     // Search for right neighbour
                     if(c<width-1){
                         for(int x = c+1; x<width ; x++){
                             if(matrix[r][x] == '0'){
                                 outline = outline.concat(" "+x+" "+r); // If right neigb. found
                                 foundR = true; 
                                 break; 
                             }
                         }
                         if(!foundR) outline = outline.concat(" -1 -1"); // If right neighb. not found
                     }
                     else outline = outline.concat(" -1 -1"); // If node is at right edge - Have no neighb.
                     
                     //Search for bottom neightbour
                     if(r<height-1){
                         for(int x = r+1; x<height; x++){
                             if(matrix[x][c] == '0'){
                                 outline = outline.concat(" "+c+" "+x); // if bottom neighb. found
                                 foundB = true; 
                                 break; 
                             }
                         }
                         if(! foundB) outline = outline.concat(" -1 -1"); // if bottom neighb. not found
                     }
                     else outline = outline.concat(" -1 -1"); // If node is at bottom edge - Have no neighb.
                     
                     System.out.println(outline) ;                
                }
            }
           
        }
    }
}