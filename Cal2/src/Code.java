
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Code extends JFrame {
	private double op1 = 0;
	private double op2 = 0;
	private String operator = "+";
	private JLabel status;
	
	
	public Code() {
		this.setTitle(" 임희정의 계산기 ");
		Image icon = Toolkit.getDefaultToolkit().getImage("calc.png");
		this.setIconImage(icon);
		this.setBounds(100, 100, 400, 450);
		this.setLayout(new BorderLayout()); //위치를 지정해서 붙일수있음
		
		JTextField display = new JTextField("0");
		display.setFont(new Font("돋움체",0,30));
		display.setHorizontalAlignment(JTextField.RIGHT); //정렬
		this.add(BorderLayout.NORTH,display); //좌표지정필요없이 위치만 잡기
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,4));
		
		
		JButton btnCE = new JButton("CE");
		btnCE.addActionListener( e -> {
			if(op1!=0 && op2!=0) {
			op2 =0;}
			operator = "+";
			display.setText("0");
			status.setText("0");
		});
		
		panel.add(btnCE);	
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener( e -> {
			op1 =0;
			op2 =0;
			operator = "+";
			display.setText("0");
			status.setText(" ");
		});
		panel.add(btnClear);
		
		JButton btnDvi = new JButton("/");
		btnDvi.addActionListener( e -> {
			op1 = Double.parseDouble( display.getText());
			display.setText("0");
			operator = "/";
			status.setText(op1 + "/");
			});
		panel.add(btnDvi);		
		
		JButton btnDel = new JButton("←"); //지우기 버튼 
		btnDel.addActionListener( e -> {
			display.setText("0");
		
			});
			panel.add(btnDel);
			
			
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");
		
		panel.add(btn7);panel.add(btn8);panel.add(btn9);
		
		JButton btnMulti = new JButton("x");
		btnMulti.addActionListener( e -> {
			op1 = Double.parseDouble( display.getText());
			display.setText("0");
			operator = "*";
			status.setText(op1 + "*");
			});
			panel.add(btnMulti);
			
			
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");

		panel.add(btn4);panel.add(btn5);panel.add(btn6);
		
		JButton btnMin = new JButton("-");
		btnMin.addActionListener( e -> {
			op1 = Double.parseDouble( display.getText());
			display.setText("0");
			operator = "-";
			status.setText(op1 + "-");
			});
			panel.add(btnMin);
			
			
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");	
		panel.add(btn1);panel.add(btn2);panel.add(btn3);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener( e -> {
			op1 = Double.parseDouble( display.getText());
			display.setText("0");
			operator = "+";
			status.setText(op1 + "+");
		});
		panel.add(btnPlus);
		
		
					
		JButton btnPm = new JButton("+/-");
		btnPm.addActionListener( e -> {
			op1 = Double.parseDouble( display.getText());
			if(op1>0) {
			op1 = -op1;
			status.setText(""+op1);}
			else{
				op1 = -op1;
				status.setText(""+ op1);
			}
			display.setText(""+op1);
			
		});
		
		panel.add(btnPm);	
		
		JButton btn0 = new JButton("0"); 
		panel.add(btn0);
		
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener( e -> {
			if( !display.getText().contains(".") ) {
			display.setText( display.getText() + btnDot.getText() );
			}
		});
		panel.add(btnDot);
		


		
		
		/*for(int i=0; i<10; i++) {
			JButton btn = new JButton(""+i); //string으로 만들때 "" 붙이기
			btn.addActionListener(e -> {
				if(display.getText().equals("0") ) { 
					// 0 나오는거 입력하면 지우기
					display.setText( btn.getText());
				} else {
				display.setText( display.getText() + btn.getText());
			}
			});  
			
			panel.add(btn); 
		} */
		
		
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(e -> {
			op2 = Double.parseDouble( display.getText());
			double result = calc(op1, op2, operator);
			switch( operator ) {
			case "+":
				status.setText(op1 + "+" + op2 + "=");
				break;
			case "-":
				status.setText(op1 + "-" + op2 + "=");
				break;
			case "*":
				status.setText(op1 + "*" + op2 + "=");
				break;
			case "/":
				status.setText(op1 + "/" + op2 + "=");
				break;
			}
			display.setText(""+ result);
			//status.setText(op2 + "="); 여기 뭔가 다시해야함
		});
		panel.add(btnEqual);
		
		
		
		this.add(BorderLayout.CENTER,panel); //굳이 CENTER안써도 되긴함 플러스밑에 있었음 원래 
		
		//string 에 포함되어 있는지 알때 str.contains(어쩌구) 하면 된다 
		
		
		
		btn7.addActionListener(e -> {
			if(display.getText().equals("0") ) { 

				display.setText( btn7.getText());
			} else {
			display.setText( display.getText() + btn7.getText());
		}
		});
		
		btn8.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
				
				display.setText( btn8.getText());
			} else {
			display.setText( display.getText() + btn8.getText());
		}
		});  
		btn9.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
				
				display.setText( btn9.getText());
			} else {
			display.setText( display.getText() + btn9.getText());
		}
		}); 
		
		btn0.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
			
				display.setText( btn0.getText());
			} else {
			display.setText( display.getText() + btn0.getText());
		}
		});  
		
		btn1.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
				
				display.setText( btn1.getText());
			} else {
			display.setText( display.getText() + btn1.getText());
		}
		});  
		
		btn2.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
				
				display.setText( btn2.getText());
			} else {
			display.setText( display.getText() + btn2.getText());
		}
		});  
		
		btn3.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
				
				display.setText( btn3.getText());
			} else {
			display.setText( display.getText() + btn3.getText());
		}
		});  
		
		btn4.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
				
				display.setText( btn4.getText());
			} else {
			display.setText( display.getText() + btn4.getText());
		}
		});  
		
		btn5.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
				
				display.setText( btn5.getText());
			} else {
			display.setText( display.getText() + btn5.getText());
		}
		});  
		
		btn6.addActionListener(e -> {
			if(display.getText().equals("0") ) { 
				
				display.setText( btn6.getText());
			} else {
			display.setText( display.getText() + btn6.getText());
		}
		});  
		
		
		
		
	
		
		
			
		
			
		
		
			status = new JLabel("버튼을 클릭하세요");
			this.add(BorderLayout.SOUTH, status );
	}
	
	
		

	private double calc(double op1, double op2, String operator) {
		double result = 0;
		switch( operator ) {
		case "+":
			result = op1 + op2;
			break;
		case "-":
			result = op1 - op2;
			break;
		case "*":
			result = op1 * op2;
			break;
		case "/":
			result = op1 / op2;
			break;
		}
		
		return result;
	}

	public static void main(String[] args) {
		new Code().setVisible(true);
	
	
	
	
	}

}