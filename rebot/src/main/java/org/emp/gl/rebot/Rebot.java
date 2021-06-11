package org.emp.gl.rebot;

import org.emp.gl.rebotinterface.RebotAbstract;


public class Rebot extends RebotAbstract {

    final static String UP_PROP = "up" ;
    final static String DOWN_PROP = "down" ;
    final static String LEFT_PROP = "left" ;
    final static String RIGHT_PROP = "right" ;




    public Rebot(int x, int y, String direction, int mat[][]){
        this.direction = direction;
        super.x = x;
        super.y = y;
        if(mat[x][y] == 1){
            System.out.println("Please Change Start Position Of Robot");
            return;
        }
        super.matrice = mat;

    }

    @Override
    public void move(){
        if(this.direction == DOWN_PROP){
            if(y < 9 && matrice[y+1][x] != 1) {
                this.y++;
                System.out.println("Avancé y++: ("+ x + "," + y + ")");
            }
            else {
                System.out.println("Obstacle Ne Peut Pas Avancé y++: ("+ x + "," + (y+1) + ")");
            }
        }
        if(this.direction == UP_PROP){
            if(y > 0 && matrice[y-1][x] != 1) {
                this.y--;
                System.out.println("Avancé y--: ("+ x + "," + y + ")");
            }
            else {
                System.out.println("Obstacle Ne Peut Pas Avancé y--: ("+ x + "," + (y-1)+ ")");
            }
        }
        if(this.direction == LEFT_PROP){
            if(x > 0 && matrice[y][x-1] != 1) {
                this.x--;
                System.out.println("Avancé x--: ("+ x + "," + y + ")");
            }
            else {
                System.out.println("Obstacle Ne Peut Pas Avancé x--: ("+ (x-1) + "," + y + ")");
            }
        }
        if(this.direction == RIGHT_PROP){
            if(x < 9 && matrice[y][x+1] != 1) {
                this.x++;
                System.out.println("Avancé x++: ("+ x + "," + y + ")");
            }
            else {
                System.out.println("Obstacle Ne Peut Pas Avancé x++: ("+ (x+1) + "," + y + ")");
            }
        }
    }


    @Override
    public void up() {
        if(direction != DOWN_PROP){
            this.direction = UP_PROP;
        }
    }

    @Override
    public void down() {
        if(direction != UP_PROP){
            this.direction = DOWN_PROP;
        }
    }

    @Override
    public void left() {
        if(direction != RIGHT_PROP){
            this.direction = LEFT_PROP;
        }
    }

    @Override
    public void right() {
        if(direction != LEFT_PROP){
            this.direction = RIGHT_PROP;
        }
    }


}
