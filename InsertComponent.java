import java.awt.*;

import javax.swing.JPanel;

public class InsertComponent extends JPanel {
	private InsertionSort sorter;
	private Thread t;
	public InsertComponent() {
		setPreferredSize(new Dimension(500, 200));
		setBackground(Color.white);
		int[] randoms = { 8, 11, 26, 15, 19, 22, 14, 21, 27, 20, 29, 7, 16, 10, 5, 6, 17, 24, 23, 25, 28, 18, 12, 9, 13 };
		sorter = new InsertionSort(randoms, this);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		sorter.draw(g2);
	}
	
	public void startAnimation() {
		class AnimationRunnable implements Runnable{
			public void run() {
				try {
					sorter.insertSort();
				}catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		Runnable r = new AnimationRunnable();
		t = new Thread(r);
		t.start();
	}
	
	public void stop() throws InterruptedException{
		t.interrupt();
	}
}
