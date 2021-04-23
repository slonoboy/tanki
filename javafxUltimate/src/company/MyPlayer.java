package company;

public class MyPlayer implements Player{
    Map map;
    Position position;

    @Override
    public void setMap(Map map){
        this.map = map;
    }

    @Override
    public void moveRight(){
        int column = position.getX();
        int row = position.getY();
        if (column + 1 != map.getSize()) {
            if (map.map[row][column + 1] == 'T' || map.map[row][column + 1] == '0') {
                map.map[row][column] = '0';
                map.map[row][column + 1] = 'P';
                position.setX(column + 1);
            }
        }
    }

    @Override
    public void moveLeft(){
        int column = position.getX();
        int row = position.getY();
        if (column - 1 != -1) {
            if(map.map[row][column - 1] == 'T' || map.map[row][column - 1] == '0'){
            map.map[row][column] = '0';
            map.map[row][column - 1] = 'P';
            position.setX(column - 1);
            }
        }
    }

    @Override
    public void moveUp(){
        int column = position.getX();
        int row = position.getY();
        if (row - 1 != -1) {
            if (map.map[row - 1][column] == '0' || map.map[row - 1][column] == 'T') {
                map.map[row][column] = '0';
                map.map[row - 1][column] = 'P';
                position.setY(row - 1);
            }
        }
    }

    @Override
    public void moveDown(){
        int column = position.getX();
        int row = position.getY();
        if (row + 1 != map.getSize()) {
            if (map.map[row + 1][column] == '0' || map.map[row + 1][column] == 'T') {
                map.map[row][column] = '0';
                map.map[row + 1][column] = 'P';
                position.setY(row + 1);
            }
        }
    }

    @Override
    public Position getPosition(){
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                if (map.map[i][j] == 'P'){
                    position = new Position(j, i);
                }
            }
        }
        return position;
    }

}
