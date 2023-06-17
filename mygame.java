import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
public class mygame {
    public static int keyCode;
    public static int boundone;
    public static int boundtwo;
    public static int onecheck;
    public static int twocheck;
    static int numbers[][] = new int[4][4];  

    public void printarray(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        } 
    }
    //see line 110 on why this function is implemented
    public void uparrow(){
        //add each value in the array to the value of the column above
        //j row, i column
        for (int j=0; j<4; j++){
            for (int i=0; i<4; i++){
                for (int y=3; y>0; y--){
                    if ((numbers[y][j]!=0) && (numbers[y-1][j]==0)){
                        numbers[y-1][j] = numbers[y][j];
                        numbers[y][j]=0;
                    }
                }
            }
        }

        for ( int j=0; j<4; j++){
            for ( int x=0; x<3; x++){
                if ((numbers[x][j] == numbers[x+1][j])){
                    numbers[x][j] = numbers[x][j] + numbers[x+1][j];
                     numbers[x+1][j] = 0;
                }
            }
        } 
    }
    //see line 121 on why this function is implemented
    public void downarrow(){
        //add each value in the array to the value of the column above
        for (int j=0; j<4; j++){
            for (int i=0; i<4; i++){
                for (int y=0; y<3; y++){
                    if ((numbers[y][j]!=0) && (numbers[y+1][j]==0)){
                        numbers[y+1][j] = numbers[y][j];
                        numbers[y][j]=0;
                    }
                }
            }
        }
        for (int j=0; j<4; j++){
            for (int x=3; x>0; x--){
                if ((numbers[x][j] == numbers[x-1][j])){
                    numbers[x][j] = numbers[x][j] + numbers[x-1][j];
                    numbers[x-1][j] = 0;
                }
            }
        } 
    }
    //see line 171
    public void leftarrow(){
        for (int j=0; j<4; j++){
            for (int i=0; i<4; i++){
                for (int y=1; y<4; y++){
                    if ((numbers[j][y]!=0) && (numbers[j][y-1]==0)){
                        numbers[j][y-1] = numbers[j][y];
                        numbers[j][y]=0;
                    }
                }
            }
        } 
        for (int j=0; j<4; j++){
            for (int x=1; x<4; x++){
                if ((numbers[j][x] == numbers[j][x-1])){
                    numbers[j][x-1] = numbers[j][x] + numbers[j][x-1];
                    numbers[j][x] = 0;
                }
            }
        } 
    }
    //line 183
    public void rightarrow(){
        for (int j=0; j<4; j++){
            for (int i=0; i<4; i++){
                for (int y=0; y<3; y++){
                    if ((numbers[j][y]!=0) && (numbers[j][y+1]==0)){
                        numbers[j][y+1] = numbers[j][y];
                        numbers[j][y]=0;
                    }
                }
            }
        } 
        for (int j=0; j<4; j++){
            for (int x=3; x>0; x--){
                if ((numbers[j][x] == numbers[j][x-1])){
                    numbers[j][x] = numbers[j][x] + numbers[j][x-1];
                    numbers[j][x-1] = 0;
                }
            }
        } 
    }

    public static void main(String[] args){
        //set 2 random numbers of the array equal to 2
        Random rand = new Random();
        boundone = 0;
        boundtwo = 0;
        onecheck = rand.nextInt(4);
        twocheck = rand.nextInt(4);

        for (int i=0; i<2; i++){
            while ((onecheck ==boundone) || (twocheck == boundtwo)){
                if (onecheck == boundone){
                    boundone = rand.nextInt(4);
                }else{
                    boundtwo = rand.nextInt(4);
                }
            }
            numbers[boundone][boundtwo] = 2;
            onecheck = boundone;
            twocheck = boundtwo;
        }
        //set all other numbers to 0
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (numbers[i][j]!=2){
                    //i = row, j = column
                    numbers[i][j]=0;
                }
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        } 

        //arrows pressed to activate game:
        JFrame myJFrame = new JFrame();
        myJFrame.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                keyCode = e.getKeyCode();
                //if up arrow pressed
                if (keyCode == KeyEvent.VK_UP){
                    System.out.println("Up Arrow Pressed");
                    new mygame().uparrow();
                    while (numbers[boundone][boundtwo]!=0){
                        boundone = rand.nextInt(4);
                        boundtwo = rand.nextInt(4);
                    }
                    numbers[boundone][boundtwo] = 2; 
                    new mygame().printarray();
                }
                //if down arrow pressed
                if (keyCode == KeyEvent.VK_DOWN){
                    System.out.println("Down Arrow Pressed");
                    new mygame().downarrow();
                    while (numbers[boundone][boundtwo]!=0){
                        boundone = rand.nextInt(4);
                        boundtwo = rand.nextInt(4);
                    }
                    numbers[boundone][boundtwo] = 2;
                    new mygame().printarray();
                }
                //if left arrow pressed
                if (keyCode == KeyEvent.VK_LEFT){
                    System.out.println("Left Arrow Pressed");
                    new mygame().leftarrow();
                    while (numbers[boundone][boundtwo]!=0){
                        boundone = rand.nextInt(4);
                        boundtwo = rand.nextInt(4);
                    }
                    numbers[boundone][boundtwo] = 2;
                    new mygame().printarray();
                     
                }
                //if right arrow pressed
                if (keyCode == KeyEvent.VK_RIGHT){
                    System.out.println("Right Arrow Pressed");
                    new mygame().rightarrow();
                    while (numbers[boundone][boundtwo]!=0){
                        boundone = rand.nextInt(4);
                        boundtwo = rand.nextInt(4);
                    }
                    numbers[boundone][boundtwo] = 2;
                    new mygame().printarray(); 
                }
            }
        });
        myJFrame.setVisible(true);
    }
}
