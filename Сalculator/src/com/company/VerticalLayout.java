package com.company;

import java.awt.*;
import javax.swing.*;

public class VerticalLayout implements LayoutManager{

    private Dimension size = new Dimension();

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return calculateBestSize(parent);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return calculateBestSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        Component list[] = parent.getComponents();
        int currentY = 10;
        for (int i = 0;i < list.length;i++){
            Dimension pref = list[i].getPreferredSize();
            list[i].setBounds(5, currentY, pref.width, pref.height);
            currentY +=5+pref.height;

        }
    }

    private Dimension calculateBestSize(Container c){
        Component list[] = c.getComponents();
        int maxWidth = 0;
        for (int i =0;i < list.length;i++){
            if(maxWidth < list[i].getWidth())
                maxWidth = list[i].getWidth();
        }
        size.width = maxWidth +10;
        for (int i =0;i < list.length;i++) size.height += 10 + list[i].getHeight();

            return size;
    }
}
