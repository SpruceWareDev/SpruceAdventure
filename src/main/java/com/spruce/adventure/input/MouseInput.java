package com.spruce.adventure.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseMotionListener, MouseListener {

    private int mouseX, mouseY;
    private boolean leftPressed, rightPressed;

    private static MouseInput mouseInput;

    public static MouseInput get(){
        if(mouseInput == null){
            mouseInput = new MouseInput();
        }
        return mouseInput;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        switch (mouseEvent.getButton()){
            case MouseEvent.BUTTON1:
                leftPressed = true;
            case MouseEvent.BUTTON2:
                rightPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        leftPressed = false;
        rightPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
