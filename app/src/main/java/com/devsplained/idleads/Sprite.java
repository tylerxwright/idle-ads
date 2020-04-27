package com.devsplained.idleads;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11Ext;

public class Sprite extends Renderable {

    private int textureName;
    private int resourceId;

    public void draw(GL10 gl) {
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureName);
        ((GL11Ext)gl).glDrawTexfOES(x, y, z, width, height);
    }

}
