package com.hz;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class DemoScrollBarUI extends BasicScrollBarUI {
    public final static String CURRENT_DIR = System.getProperty("user.dir");
    public String path=CURRENT_DIR+File.separator +"icon"+File.separator+"about.png";
	 @Override
	 
	     protected void configureScrollBarColors() {
	 
	         // 把手
	 
//	       thumbColor = Color.GRAY;
	
//	       thumbHighlightColor = Color.BLUE;
	 
//	       thumbDarkShadowColor = Color.BLACK;
	 
//	       thumbLightShadowColor = Color.YELLOW;
	 
	          
	 
	         // 滑道
	 
	         trackColor = Color.WHITE;
	 
//	       trackHighlightColor = Color.GREEN;
	 
	     }
	 
	  
	 
	     @Override
	
	     protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
	
	         super.paintTrack(g, c, trackBounds);
	 
	     }
	 
	      
	     @Override
	 protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
	
	         // 把绘制区的x，y点坐标定义为坐标系的原点
	 
	         // 这句一定一定要加上啊，不然拖动就失效了
	 
	         g.translate(thumbBounds.x, thumbBounds.y);
	 
	         // 设置把手颜色
	 
	         g.setColor(Color.BLACK);
	 
	         // 画一个圆角矩形
	 
	         // 这里面前四个参数就不多讲了，坐标和宽高
	 
	         // 后两个参数需要注意一下，是用来控制角落的圆角弧度
	 
	         g.drawRoundRect(5, 0, 6, thumbBounds.height-1, 5, 5);
	 
	         // 消除锯齿
	 
	        Graphics2D g2 = (Graphics2D) g;
	 
	         RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	 
	         g2.addRenderingHints(rh);
	 
	         // 半透明
	 
	         g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
	 
	         // 设置填充颜色，这里设置了渐变，由下往上
	 
	         // g2.setPaint(new GradientPaint(c.getWidth() / 2, 1, Color.GRAY, c.getWidth() / 2, c.getHeight(), Color.GRAY));
	 
	         // 填充圆角矩形
	 
	         g2.fillRoundRect(5, 0, 6, thumbBounds.height-1, 5, 5);
	 
	     }
	 
	      
	 
	     @Override
	 
	     protected JButton createIncreaseButton(int orientation) {
	 
	         JButton button = new JButton(produceImage(path));
	 
	         button.setBorder(null);
	 
	         return button;
	 
	     }
	 
	     
	 
	     @Override
	 
	     protected JButton createDecreaseButton(int orientation) {
	 
	         JButton button = new JButton(produceImage(path));
	 
	         button.setBorder(null);
	 
	         return button;
	 
	     }
	 
	      
	 
	     /**
	 
	      * 获取图片
	 
	      * @param name 图片名称
	 
	      * @return
	 
	      */
	 
	     private ImageIcon produceImage(String name) {
	 
	         ImageIcon backImage = new ImageIcon(name);
	         return backImage;
	 
	     }
	 
	      

}
