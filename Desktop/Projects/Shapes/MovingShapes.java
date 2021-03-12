import java.awt.*;
import java.util.Scanner;

public class MovingShapes {

    public static int pWidth;
    public static int pHeight;
    public static int numMoves;
    public static String objColor;

    public static String[] shape;
    public static int[] size;
    public static String[] color;
    public static int[] direction;
    public static int[] speed;
    public static int[] xPos;
    public static int[] yPos;

    public static Scanner scnr = new Scanner(System.in);
    public static Graphics pen;

    public static void getShapeInformation(int numShapes) {
    int i;

        for (i = 0; i < numShapes; i++) {
            shape[i] = scnr.next();
            size[i] = scnr.nextInt();
            color[i] = scnr.next();
            direction[i] = scnr.nextInt();
            speed[i] = scnr.nextInt();
        }

    }

    public static void initialPosition(DrawingPanel panel) {
        int i;
        boolean bTrue = true;

        for (i = 0; i < xPos.length; i++) {

        xPos[i] = (pWidth / 2) - (size[i] / 2);
        yPos[i] = (pHeight / 2) - (size[i] / 2);


        }
        showShapes(panel, bTrue);
        panel.sleep(100);
    }

    public static void showShapesMoving(DrawingPanel panel) {
        int i;
        boolean ifFalse = false;
        boolean ifTrue = true;

        for (i = 0; i < numMoves; i++) {
        showShapes(panel, ifFalse);
        changePositions(panel);
        showShapes(panel, ifTrue);
        panel.sleep(100);
        }

    }

    public static void changePositions(DrawingPanel panel) {
        int i = 0;

        for (i = 0; i < xPos.length; i++) {

            if (direction[i] == 0) {
                xPos[i] = xPos[i] - speed[i];
            }
            if (direction[i] == 1) {
                xPos[i] = xPos[i] - speed[i];
                yPos[i] = yPos[i] - speed[i];
            }
            if (direction[i] == 2) {
                yPos[i] = yPos[i] - speed[i];
            }
            if (direction[i] == 3) {
                xPos[i] = xPos[i] + speed[i];
                yPos[i] = yPos[i] + speed[i];
            }
            if (direction[i] == 4) {
                xPos[i] = xPos[i] + speed[i];
            }
            if (direction[i] == 5) {
                xPos[i] = xPos[i] + speed[i];
                yPos[i] = yPos[i] + speed[i];
            }
            if (direction[i] == 6) {
                yPos[i] = yPos[i] + speed[i];
            }

        }
    }

    public static void showShapes(DrawingPanel panel, boolean bTrueFalse) {
        int i;
        for (i = 0; i < shape.length; i++) {

            if (bTrueFalse == true) {

                graphicsSetColor(panel, i);

            } else {

                setNoColor(panel);

            }

            switch (shape[i].toLowerCase())  {

                case "square":
                    showSquare(panel, i, bTrueFalse);
                    break;

                default:
                    showCircle(panel, i, bTrueFalse);
                    break;

            }

        }

    }

    public static void setNoColor(DrawingPanel panel) {
        pen.setColor(Color.white);
    }

    public static void graphicsSetColor(DrawingPanel panel, int shapeNum) {


        switch (color[shapeNum].toLowerCase()) {

            case "red":
                pen.setColor(Color.red);
                break;

            case "blue":
                pen.setColor(Color.blue);
                break;

            case "pink":
                pen.setColor(Color.pink);
                break;

            case "yellow":
                pen.setColor(Color.yellow);
                break;

            case "green":
                pen.setColor(Color.green);
                break;

            case "magenta":
                pen.setColor(Color.magenta);
                break;

            case "orange":
                pen.setColor(Color.orange);
                break;

            case "dark_gray":
                pen.setColor(Color.darkGray);
                break;

            case "light_gray":
                pen.setColor(Color.lightGray);
                break;

            case "gray":
                pen.setColor(Color.gray);
                break;

            default:
                pen.setColor(Color.black);
                break;

        }


    }

    public static void showSquare(DrawingPanel panel, int shapeNum, boolean tFalse) {

        pen.fillRect(xPos[shapeNum],yPos[shapeNum],size[shapeNum],size[shapeNum]);

        if (tFalse) {
            pen.setColor(Color.black);
        }

        pen.drawRect(xPos[shapeNum],yPos[shapeNum],size[shapeNum],size[shapeNum]);
    }

    public static void showCircle(DrawingPanel panel, int shapeNum, boolean tFalse) {

        pen.fillOval(xPos[shapeNum],yPos[shapeNum],size[shapeNum],size[shapeNum]);

        if (tFalse) {
            pen.setColor(Color.black);
        }

        pen.drawOval(xPos[shapeNum],yPos[shapeNum],size[shapeNum],size[shapeNum]);
    }

    public static void main(String[] args) {
        System.out.println("UTSA - Fall 2020 - cs1083 - Section 003 - Project 3 - Written by Austin Moore");
        System.out.println("");
        System.out.print("Please input width, height of the panel, # of shapes, # of times to move followed by the shape, size, color, orientation, and speed of every shape: ");

        pWidth = scnr.nextInt();
        pHeight = scnr.nextInt();
        int numShapes = scnr.nextInt();
        numMoves = scnr.nextInt();
        int i;

        shape = new String[numShapes];
        size = new int[numShapes];
        color = new String[numShapes];
        direction = new int[numShapes];
        speed = new int[numShapes];
        yPos = new int[numShapes];
        xPos = new int[numShapes];

        getShapeInformation(numShapes); // Gets information for every shape
        DrawingPanel panel = new DrawingPanel(pWidth,pHeight); // shows drawing panel
        pen = panel.getGraphics();
        panel.setBackground(Color.white);
        initialPosition(panel); // Calculates first position of shape
        showShapesMoving(panel); // Performs shape movement
    }
}
