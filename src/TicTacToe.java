import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class TicTacToe extends JFrame implements ActionListener{
           
            JPanel receiver;
            JButton[][] matrix;
            int[][] data;
            int winner;
            int level;
            ImageIcon cross, circle;
           
            public static void main (String[] args) {
                       
                        new TicTacToe();
                       
            }
           
            public TicTacToe () {
           
                        super("TicTacToe");
                        setSize(600, 600);
                        setResizable(false);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       
                        setup(1);                      
                       
                        cross= new ImageIcon("cross.png");
                        circle= new ImageIcon("circle.png");
                       
                        add(receiver);
                       
                        setVisible(true);
                       
            }
           
            public void setup (int lvl) {
                       
                        receiver= new JPanel();
                        receiver.setLayout(new GridLayout(3, 3));
                       
                        matrix= new JButton[3][3];
                        data= new int[3][3];
                       
                        winner= 0;
                        level= lvl;
                       
                        for (int i= 0; i<matrix.length; i++) {
                                    for (int j= 0; j<matrix.length; j++) {
                                   
                                                data[i][j]= 0;
                                                matrix[i][j]= new JButton();
                                                matrix[i][j].setActionCommand(i+":"+j);
                                                matrix[i][j].addActionListener(this);
                                                receiver.add(matrix[i][j]);
                                   
                                    }                                  
                        }
                       
            }
           
            public void actionPerformed (ActionEvent e) {
                       
                        String s= e.getActionCommand();
                        int i= Integer.parseInt(s.substring(0, s.indexOf(':')));
                        int j= Integer.parseInt(s.substring(s.indexOf(':')+1));
                        
                        data[i][j]= 1;
                        matrix[i][j].setIcon(cross);
                        matrix[i][j].setEnabled(false);
                       
                        if (countzero() != 0 && over()) {
                        	computer_turn();
                        }
            }
           
            public void computer_turn () {
                       
                        int i= 0;
                        int j= 0;
                       
            search:
                        switch(level) {
                                    case 0:
                                               
                                                int h;
                                               
                                                for (int m= 0; m<3; m++) {
                                                           
                                                            h= -(7*m*m)/2+15*m/2-2;
                                                            System.out.println(h);
                                                           
                                                            for (int k= 0; k<3; k++) {
                                               
                                                                        if (data[0][k]+data[1][k]+data[2][k] == h) {
                                                                                   
                                                                                    if (data[0][k] == 0) {
                                                                                               
                                                                                                i= 0;
                                                                                                j= k;
                                                                                                break search;
                                                                                               
                                                                                    } else if (data[1][k] == 0) {
                                                                                               
                                                                                                i= 1;
                                                                                                j= k;
                                                                                                break search;
                                                                                               
                                                                                    } else if (data[2][k] == 0) {
                                                                                               
                                                                                                i= 2;
                                                                                                j= k;
                                                                                                break search;
                                                                                               
                                                                                    }
                                                                                   
                                                                        }
                                                                       
                                                                        if (data[k][0]+data[k][1]+data[k][2] == h) {
                                                                        	
                                                                        	//System.out.println("line"+k);
                                                                        	//System.out.println("sum:"+data[0][k]+" "+data[1][k]+" "+data[2][k]);
                                                                                   
                                                                                    if (data[k][0] == 0) {
                                                                                               
                                                                                                i= k;
                                                                                                j= 0;
                                                                                                break search;
                                                                                               
                                                                                    } else if (data[k][1] == 0) {
                                                                                               
                                                                                                i= k;
                                                                                                j= 1;
                                                                                                break search;
                                                                                               
                                                                                    } else if (data[k][2] == 0) {
                                                                                               
                                                                                                i= k;
                                                                                                j= 2;
                                                                                                break search;
                                                                                               
                                                                                    }
                                                                                   
                                                                        }
                                                                       
                                                            }
                                                           
                                                            if (data[0][0]+data[1][1]+data[2][2] == h) {
                                                                       
                                                                        if (data[0][0] == 0) {
                                                                                               
                                                                                                i= 0;
                                                                                                j= 0;
                                                                                                break search;
                                                                                               
                                                                                    } else if (data[1][1] == 0) {
                                                                                               
                                                                                                i= 1;
                                                                                                j= 1;
                                                                                                break search;
                                                                                               
                                                                                    } else if (data[2][2] == 0) {
                                                                                               
                                                                                                i= 2;
                                                                                                j= 2;
                                                                                                break search;
                                                                                               
                                                                                    }
                                                           
                                                            }
                                                           
                                                            if (data[2][0]+data[1][1]+data[0][2] == h) {
                                                           
                                                                        if (data[2][0] == 0) {
                                                                                               
                                                                                                i= 2;
                                                                                                j= 0;
                                                                                                break search;
                                                                                               
                                                                                    } else if (data[1][1] == 0) {
                                                                                               
                                                                                                i= 1;
                                                                                                j= 1;
                                                                                                break search;
                                                                                               
                                                                                    } else if (data[0][2] == 0) {
                                                                                               
                                                                                                i= 0;
                                                                                                j= 2;
                                                                                                break search;
                                                                                               
                                                                                    }
                                                           
                                                            }
                                                           
                                                }
                                               
                                                do {
                                                	System.out.println("humpfs");
                                                            int n= (int)(Math.random()*9);
                                                            i= (n-n%3)/3;
                                                            j= n%3;
                                                } while (data[i][j] != 0);
                                               
                                                break;
                                               
                                    case 1:
                                    			
                                    			if (countzero() == 8) {
                                    				if (data[1][1] == 0) {
                                    					i= 1;
                                    					j= 1;
                                    				} else {
                                    					i= 0;
                                    					j= 0;
                                    				}
                                    			} else if (countzero() == 6){
                                    				if (sweetspot()) {
                                    					if (data[0][0]+data[2][2] == 2 || data[0][2]+data[2][0] == 2) {
                                    						i= 0;
                                    						j= 1;
                                    						break search;
                                    					} else {
                                    						int[] ij= findcorner();
                                    						i= ij[0];
                                    						j= ij[1];
                                    						break search;
                                    					}
                                    				} else {
                                    					level= 0;
                                    					computer_turn();
                                    					return;
                                    				}
                                    			} else {
                                    				level= 0;
                                    				computer_turn();
                                    				return;
                                    			}
                                                break;
                                               
                                    default:
                                                return;
                        }
                       System.out.println();
                        data[i][j]= -1;
                        matrix[i][j].setIcon(circle);
                        matrix[i][j].setEnabled(false);
                       
                        over();
                       
            }
            
            public boolean sweetspot () {
            	boolean a= (data[0][0]+data[0][1]+data[0][2] == 1) && (data[0][0]+data[1][0]+data[2][0] == 1) && data[0][0] != 1;
            	boolean b= (data[2][0]+data[2][1]+data[2][2] == 1) && (data[0][0]+data[1][0]+data[2][0] == 1) && data[2][0] != 1;
            	boolean c= (data[0][0]+data[0][1]+data[0][2] == 1) && (data[0][2]+data[1][2]+data[2][2] == 1) && data[0][2] != 1;
            	boolean d= (data[2][0]+data[2][1]+data[2][2] == 1) && (data[0][2]+data[1][2]+data[2][2] == 1) && data[2][2] != 1;
            	if (a || b || c || d) {
            		return true;
            	} else {
            		return false;
            	}
            	
            }
            
            public int[] findcorner () {
            	
            	if ((data[0][0]+data[0][1]+data[0][2] == 1) && (data[0][0]+data[1][0]+data[2][0] == 1) && data[0][0] != 1){
            		System.out.println("|-");
   
            		int[] ij= {0,0};
            		return ij;
            	}
            	
            	if ((data[2][0]+data[2][1]+data[2][2] == 1) && (data[0][0]+data[1][0]+data[2][0] == 1) && data[2][0] != 1) {
            		System.out.println("|_");
            		int[] ij= {2,0};
            		return ij;
            	}
            	
            	if ((data[0][0]+data[0][1]+data[0][2] == 1) && (data[0][2]+data[1][2]+data[2][2] == 1) && data[0][2] != 1) {
            		System.out.println("-|");

            		int[] ij= {0,2};
            		return ij;
            	}
        		System.out.println("_|");

            	int[] ij= {2,2};
            	return ij;
            }
            
           
            public boolean over () {
                       
                        for (int k= 0; k<3; k++) {
                                   
                                    if (Math.abs(data[0][k]+data[1][k]+data[2][k]) == 3) {
                                                winner= data[0][k];
                                    }
                                   
                                    if (Math.abs(data[k][0]+data[k][1]+data[k][2]) == 3) {
                                                winner= data[k][0];
                                    }
                                   
                        }
                       
                        if (Math.abs(data[0][0]+data[1][1]+data[2][2]) == 3) {
                                   
                                    winner= data[1][1];
                       
                        }
                       
                        if (Math.abs(data[2][0]+data[1][1]+data[0][2]) == 3) {
                       
                                    winner= data[1][1];
                       
                        }
                       
                        if (winner != 0) {
                                    for (int i= 0; i<matrix.length; i++) {
                                                for (int j= 0; j<matrix.length; j++) {
                                   
                                                            matrix[i][j].setEnabled(false);     
                                   
                                                }                                  
                                    }
                                    System.out.println(winner+" won");
                                    return false;
                        }
                        
                        if (countzero() == 0) {
                        	for (int i= 0; i<matrix.length; i++) {
                                for (int j= 0; j<matrix.length; j++) {
                   
                                            matrix[i][j].setEnabled(false);     
                   
                                }                                  
                        	}
                        	System.out.println("tie");
                        }
                        
                        return true;
                       
            }
            
            public int countzero () {
            	int count= 0;
            	for (int i= 0; i<3; i++) {
            		for (int j= 0; j<3; j++) {
            			if (data[i][j] == 0) {
            				count++;
            			}
            		}
            	}
            	return count;
            }
           
}