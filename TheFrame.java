import javax.swing.JFrame;

public class TheFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Animating With Threads");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new ControlComponent());
		frame.pack();
		frame.setVisible(true);

	}

}
