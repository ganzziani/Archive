import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class StartHere implements KeyListener {
	private static StartHere instance;
	private Queue<Integer> numbers = new LinkedList<Integer>();
	private String piDigits = "1415926535 8979323846 2643383279 5028841971 6939937510 5820974944 5923078164 0628620899 8628034825 3421170679 8214808651 3282306647 0938446095 5058223172 5359408128 4811174502 8410270193 8521105559 6446229489 5493038196 4428810975 6659334461 2847564823 3786783165 2712019091 4564856692 3460348610 4543266482 1339360726 0249141273 7245870066 0631558817 4881520920 9628292540 9171536436 7892590360 0113305305 4882046652 1384146951 9415116094 3305727036 5759591953 0921861173 8193261179 3105118548 0744623799 6274956735 1885752724 8912279381 8301194912 9833673362 4406566430 8602139494 6395224737 1907021798 6094370277 0539217176 2931767523 8467481846 7669405132 0005681271 4526356082 7785771342 7577896091 7363717872 1468440901 2249534301 4654958537 1050792279 6892589235 4201995611 2129021960 8640344181 5981362977 4771309960 5187072113 4999999837 2978049951 0597317328 1609631859 5024459455 3469083026 4252230825 3344685035 2619311881 7101000313 7838752886 5875332083 8142061717 7669147303 5982534904 2875546873 1159562863 8823537875 9375195778 1857780532 1712268066 1300192787 6611195909 2164201989";
	private String output1 = "", output2 = "";
	private PiFrame frame;
	private int startAt = 0, track = 0, trackCorrect = 0, trackIncorrect = 0;
	
	public static void main(String args[]) {
		instance = new StartHere();
	}
	
	public StartHere(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame = new PiFrame(instance);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		buildQueue();
	}
	
	private void buildQueue(){
		for(int i = 0; i < piDigits.length(); i++){
			if(piDigits.charAt(i) != ' '){
				if(track >= startAt)
					numbers.offer(Integer.parseInt(Character.toString(piDigits.charAt(i))));
				track++;
			}
		}
		track = 0;
	}

	public void keyTyped(KeyEvent e) {
		try {
			int input = Integer.parseInt(Character.toString(e.getKeyChar()));
			output1+=input;
			frame.getInputArea().setText("<html><b>3."+output1+"</b></html>");
			if(input == numbers.peek()){
				output2 += numbers.poll();
				trackCorrect++;
			}else{
				output2 += "<font color = red>"+numbers.poll()+"<font color = green>";
				trackIncorrect++;
			}
			frame.getAnswerArea().setText("<html><b><font color = green>3."+output2);
			frame.setTitle("You have ouput a total of " + (trackCorrect+trackIncorrect) + " digits. Of those, " + trackCorrect + " are correct, " + trackIncorrect + " are not.");
		} catch (Exception ex){
		}
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			((JFrame)e.getSource()).dispose();
			instance = new StartHere();
		}
	}
	public void keyReleased(KeyEvent arg0) {}
}
