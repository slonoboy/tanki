package company;

import java.util.Scanner;

public class Map{
    char[][] map;

    public Map(Scanner scan) throws InvalidMapException{
        int size = scan.nextInt();
        map = new char[size][size];
        if (size == 0) throw new InvalidMapException("Map size can not be zero");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                map[i][j] = scan.next().charAt(0);
                if (map[i][j] != 'P' && map[i][j] != '0' && map[i][j] != '1' && map[i][j] != 'S' && map[i][j] != 'B' && map[i][j] != 'W' && map[i][j] != 'T' ){
                    throw new InvalidMapException("Not enough map elements");
                }
            }
        }
    }

    public int getSize() {
        return map.length;
    }

    public char getValueAt(int x, int y){
        return map[x][y];
    }

    public void print(){
        for (int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize(); j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
