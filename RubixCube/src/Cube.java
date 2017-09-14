class Cube	{
    
    final String[][][] solvedState  = { { {"W","W","W"},     // faces[0] = upFace[][]
                             {"W","W","W"},
                             {"W","W","W"} },
        
                           { {"R","R","R"},     // faces[1] = leftFace[][]
                             {"R","R","R"},
                             {"R","R","R"} },
            
                           { {"G","G","G"},     // faces[2] = frontFace[][]
                             {"G","G","G"},
                             {"G","G","G"} },
                           
                           { {"O","O","O"},     // faces[3] = rightFace[][]
                             {"O","O","O"},
                             {"O","O","O"} },
                           
                           { {"B","B","B"},     // faces[4] = backFace[][]
                             {"B","B","B"},
                             {"B","B","B"} }, 
                           
                           { {"Y","Y","Y"},     // faces[5] = downFace[][]
                             {"Y","Y","Y"},
                             {"Y","Y","Y"} }
                            
                         };
    
    String[][][] faces = { { {"W","W","W"},     // faces[0] = upFace[][]
                             {"W","W","W"},
                             {"W","W","W"} },
        
                           { {"R","R","R"},     // faces[1] = leftFace[][]
                             {"R","R","R"},
                             {"R","R","R"} },
            
                           { {"G","G","G"},     // faces[2] = frontFace[][]
                             {"G","G","G"},
                             {"G","G","G"} },
                           
                           { {"O","O","O"},     // faces[3] = rightFace[][]
                             {"O","O","O"},
                             {"O","O","O"} },
                           
                           { {"B","B","B"},     // faces[4] = backFace[][]
                             {"B","B","B"},
                             {"B","B","B"} }, 
                           
                           { {"Y","Y","Y"},     // faces[5] = downFace[][]
                             {"Y","Y","Y"},
                             {"Y","Y","Y"} }
                            
                         };
                            
                          
                           
    String[] algorithm;
    
    public Cube (String[] a) {
        algorithm = a;
    }
    
    public int doTheThing () // manages counting
    {
        int count = 0;
        do {
            for (int i = 0; i < algorithm.length; i++)
            {
                rotate (algorithm[i]);
            }
            count++;
        } while (!checkIfSolved());
        return count;
    }
    
    public void rotate (String turn) // redirects to proper turn
    {
        switch (turn)
        {
                case "U":
                {
                    rotateU();
                    break;
                }
                case "L":
                {
                    rotateL();
                    break;
                }
                case "F":
                {
                    rotateF();
                    break;
                }
                case "R":
                {
                    rotateR();
                    break;
                }
                case "B":
                {
                    rotateB();
                    break;
                }
                case "D":
                {
                    rotateD();
                    break;
                }
                case "U'":
                {
                    rotateUi();
                    break;
                }
                case "L'":
                {
                    rotateLi();
                    break;
                }
                case "F'":
                {
                    rotateFi();
                    break;
                }
                case "R'":
                {
                    rotateRi();
                    break;
                }
                case "B'":
                {
                    rotateBi();
                    break;
                }
                case "D'":
                {
                    rotateDi();
                    break;
                }
                case "u":
                {
                    rotateUU();
                    break;
                }
                case "l":
                {
                    rotateLL();
                    break;
                }
                case "f":
                {
                    rotateFF();
                    break;
                }
                case "r":
                {
                    rotateRR();
                    break;
                }
                case "b":
                {
                    rotateBB();
                    break;
                }
                case "d":
                {
                    rotateDD();
                    break;
                }
                case "u'":
                {
                    rotateUUi();
                    break;
                }
                case "l'":
                {
                    rotateLLi();
                    break;
                }
                case "f'":
                {
                    rotateFFi();
                    break;
                }
                case "r'":
                {
                    rotateRRi();
                    break;
                }
                case "b'":
                {
                    rotateBBi();
                    break;
                }
                case "d'":
                {
                    rotateDDi();
                    break;
                }
                case "M":
                {
                    rotateM();
                    break;
                }
                case "E":
                {
                    rotateE();
                    break;
                }
                case "S":
                {
                    rotateS();
                    break;
                }
                case "M'":
                {
                    rotateMi();
                    break;
                }
                case "E'":
                {
                    rotateEi();
                    break;
                }
                case "S'":
                {
                    rotateSi();
                    break;
                }
                case "U2":
                {
                    rotateU();
                    rotateU();
                    break;
                }
                case "L2":
                {
                    rotateL();
                    rotateL();
                    break;
                }
                case "F2":
                {
                    rotateF();
                    rotateF();
                    break;
                }
                case "R2":
                {
                    rotateR();
                    rotateR();
                    break;
                }
                case "B2":
                {
                    rotateB();
                    rotateB();
                    break;
                }
                case "D2":
                {
                    rotateD();
                    rotateD();
                    break;
                }
                case "M2":
                {
                    rotateM();
                    rotateM();
                    break;
                }
                case "E2":
                {
                    rotateE();
                    rotateE();
                    break;
                }
                case "S2":
                {
                    rotateS();
                    rotateS();
                    break;
                }
                case "u2":
                {
                    rotateUU();
                    rotateUU();
                    break;
                }
                case "l2":
                {
                    rotateLL();
                    rotateLL();
                    break;
                }
                case "f2":
                {
                    rotateFF();
                    rotateFF();
                    break;
                }
                case "r2":
                {
                    rotateRR();
                    rotateRR();
                    break;
                }
                case "b2":
                {
                    rotateBB();
                    rotateBB();
                    break;
                }
                case "d2":
                {
                    rotateDD();
                    rotateDD();
                    break;
                }
                default:
                    System.out.println("Fuck You " + turn);
        }
    }
    
    public void rotateU()
    {
        rotateSingleFaceCW(0);
        rotateSingleLayerHorizontalLeft(0);
    }
    
    public void rotateUi()
    {
        rotateSingleFaceCCW(0);
        rotateSingleLayerHorizontalRight(0);
    }
    
    public void rotateUU()
    {
        rotateSingleFaceCW(0);
        rotateSingleLayerHorizontalLeft(0);
        rotateSingleLayerHorizontalLeft(1);
    }
    
    public void rotateUUi()
    {
        rotateSingleFaceCCW(0);
        rotateSingleLayerHorizontalRight(0);
        rotateSingleLayerHorizontalRight(1);
    }
    
    public void rotateL()
    {
        rotateSingleFaceCW(1);
        rotateSingleLayerVerticalDown(0);
    }
    
    public void rotateLi()
    {
        rotateSingleFaceCCW(1);
        rotateSingleLayerVerticalUp(0);
    }
    
    public void rotateLL()
    {
        rotateSingleFaceCW(1);
        rotateSingleLayerVerticalDown(0);
        rotateSingleLayerVerticalDown(1);
    }
    
    public void rotateLLi()
    {
        rotateSingleFaceCCW(1);
        rotateSingleLayerVerticalUp(0);
        rotateSingleLayerVerticalUp(1);
    }
    
    public void rotateF()
    {
        rotateSingleFaceCW(2);
        rotateSingleLayerSideCW(0);
    }
    
    public void rotateFi()
    {
        rotateSingleFaceCCW(2);
        rotateSingleLayerSideCCW(0);
    }
    
    public void rotateFF()
    {
        rotateSingleFaceCW(2);
        rotateSingleLayerSideCW(0);
        rotateSingleLayerSideCW(1);
    }
    
    public void rotateFFi()
    {
        rotateSingleFaceCCW(2);
        rotateSingleLayerSideCCW(0);
        rotateSingleLayerSideCCW(1);
    }
    
    public void rotateR()
    {
        rotateSingleFaceCW(3);
        rotateSingleLayerVerticalUp(2);
    }
    
    public void rotateRi()
    {
        rotateSingleFaceCCW(3);
        rotateSingleLayerVerticalDown(2);
    }
    
    public void rotateRR()
    {
        rotateSingleFaceCW(3);
        rotateSingleLayerVerticalUp(2);
        rotateSingleLayerVerticalUp(1);
    }
    
    public void rotateRRi()
    {
        rotateSingleFaceCCW(3);
        rotateSingleLayerVerticalDown(2);
        rotateSingleLayerVerticalDown(1);
    }
    
    public void rotateB()
    {
        rotateSingleFaceCW(4);
        rotateSingleLayerSideCCW(2);
    }
    
    public void rotateBi()
    {
        rotateSingleFaceCCW(4);
        rotateSingleLayerSideCW(2);
    }
    
    public void rotateBB()
    {
        rotateSingleFaceCW(4);
        rotateSingleLayerSideCCW(2);
        rotateSingleLayerSideCCW(1);
    }
    
    public void rotateBBi()
    {
        rotateSingleFaceCCW(4);
        rotateSingleLayerSideCW(2);
        rotateSingleLayerSideCW(1);
    }
    
    public void rotateD()
    {
        rotateSingleFaceCW(5);
        rotateSingleLayerHorizontalRight(2);
    }
    
    public void rotateDi()
    {
        rotateSingleFaceCCW(5);
        rotateSingleLayerHorizontalLeft(2);
    }
    
    public void rotateDD()
    {
        rotateSingleFaceCW(5);
        rotateSingleLayerHorizontalRight(2);
        rotateSingleLayerHorizontalRight(1);
    }
    
    public void rotateDDi()
    {
        rotateSingleFaceCCW(5);
        rotateSingleLayerHorizontalLeft(2);
        rotateSingleLayerHorizontalLeft(1);
    }
    
    public void rotateM()
    {
        rotateSingleLayerVerticalDown(1);
    }
    
    public void rotateMi()
    {
        rotateSingleLayerVerticalUp(1);
    }
    
    public void rotateE()
    {
        rotateSingleLayerHorizontalRight(1);
    }
    
    public void rotateEi()
    {
        rotateSingleLayerHorizontalLeft(1);
    }
    
    public void rotateS()
    {
        rotateSingleLayerSideCW(1);
    }
    
    public void rotateSi()
    {
        rotateSingleLayerSideCCW(1);
    }
    
    
    public void rotateSingleLayerVerticalUp(int i)
    {
        String[] temp = {faces[0][0][i],faces[0][1][i],faces[0][2][i]};
        faces[0][0][i] = faces[2][0][i];
        faces[0][1][i] = faces[2][1][i];
        faces[0][2][i] = faces[2][2][i];
        faces[2][0][i] = faces[5][0][i];
        faces[2][1][i] = faces[5][1][i];
        faces[2][2][i] = faces[5][2][i];
        faces[5][0][i] = faces[4][2][2-i];
        faces[5][1][i] = faces[4][1][2-i];
        faces[5][2][i] = faces[4][0][2-i];
        faces[4][2][2-i] = temp[0];
        faces[4][1][2-i] = temp[1];
        faces[4][0][2-i] = temp[2];
    }
    
    public void rotateSingleLayerSideCW(int i)
    {
        String[] temp = {faces[0][2-i][0],faces[0][2-i][1],faces[0][2-i][2]};
        faces[0][2-i][0] = faces[1][2][2-i];
        faces[0][2-i][1] = faces[1][1][2-i];
        faces[0][2-i][2] = faces[1][0][2-i];
        faces[1][0][2-i] = faces[5][i][0];
        faces[1][1][2-i] = faces[5][i][1];
        faces[1][2][2-i] = faces[5][i][2];
        faces[5][i][0] = faces[3][2][i];
        faces[5][i][1] = faces[3][1][i];
        faces[5][i][2] = faces[3][0][i];
        faces[3][0][i] = temp[0];
        faces[3][1][i] = temp[1];
        faces[3][2][i] = temp[2];
    }
    
    public void rotateSingleLayerSideCCW(int i)
    {
        String[] temp = {faces[0][2-i][0],faces[0][2-i][1],faces[0][2-i][2]};
        faces[0][2-i][0] = faces[3][0][i];
        faces[0][2-i][1] = faces[3][1][i];
        faces[0][2-i][2] = faces[3][2][i];
        faces[3][2][i] = faces[5][i][0];
        faces[3][1][i] = faces[5][i][1];
        faces[3][0][i] = faces[5][i][2];
        faces[5][i][0] = faces[1][0][2-i];
        faces[5][i][1] = faces[1][1][2-i];
        faces[5][i][2] = faces[1][2][2-i];
        faces[1][2][2-i] = temp[0];
        faces[1][1][2-i] = temp[1];
        faces[1][0][2-i] = temp[2];
    }
    
    public void rotateSingleLayerVerticalDown(int i)
    {
        String[] temp = {faces[0][0][i],faces[0][1][i],faces[0][2][i]};
        faces[0][0][i] = faces[4][2][2-i];
        faces[0][1][i] = faces[4][1][2-i];
        faces[0][2][i] = faces[4][0][2-i];
        faces[4][2][2-i] = faces[5][0][i];
        faces[4][1][2-i] = faces[5][1][i];
        faces[4][0][2-i] = faces[5][2][i];
        faces[5][0][i] = faces[2][0][i];
        faces[5][1][i] = faces[2][1][i];
        faces[5][2][i] = faces[2][2][i];
        faces[2][0][i] = temp[0];
        faces[2][1][i] = temp[1];
        faces[2][2][i] = temp[2];
    }
    
    public void rotateSingleLayerHorizontalLeft(int i)
    {
        String[] temp = {faces[1][i][0],faces[1][i][1],faces[1][i][2]};
        faces[1][i][0] = faces[2][i][0];
        faces[1][i][1] = faces[2][i][1];
        faces[1][i][2] = faces[2][i][2];
        faces[2][i][0] = faces[3][i][0];
        faces[2][i][1] = faces[3][i][1];
        faces[2][i][2] = faces[3][i][2];
        faces[3][i][0] = faces[4][i][0];
        faces[3][i][1] = faces[4][i][1];
        faces[3][i][2] = faces[4][i][2];
        faces[4][i][0] = temp[0];
        faces[4][i][1] = temp[1];
        faces[4][i][2] = temp[2];
    }
    
    public void rotateSingleLayerHorizontalRight(int i)
    {
        String[] temp = {faces[1][i][0],faces[1][i][1],faces[1][i][2]};
        faces[1][i][0] = faces[4][i][0];
        faces[1][i][1] = faces[4][i][1];
        faces[1][i][2] = faces[4][i][2];
        faces[4][i][0] = faces[3][i][0];
        faces[4][i][1] = faces[3][i][1];
        faces[4][i][2] = faces[3][i][2];
        faces[3][i][0] = faces[2][i][0];
        faces[3][i][1] = faces[2][i][1];
        faces[3][i][2] = faces[2][i][2];
        faces[2][i][0] = temp[0];
        faces[2][i][1] = temp[1];
        faces[2][i][2] = temp[2];
    }
    
    public void rotateSingleFaceCW(int i)
    {
        String[] temp = {faces[i][0][0],faces[i][0][1],faces[i][0][2]}; // just temporary storage
        faces[i][0][0] = faces[i][2][0];
        faces[i][0][1] = faces[i][1][0];
        faces[i][0][2] = temp[0];
        faces[i][1][0] = faces[i][2][1];
        faces[i][2][0] = faces[i][2][2];
        faces[i][2][1] = faces[i][1][2];
        faces[i][2][2] = temp[2];
        faces[i][1][2] = temp[1];
    }
    
    public void rotateSingleFaceCCW(int i)
    {
        String[] temp = {faces[i][0][0],faces[i][0][1],faces[i][0][2]}; 
        faces[i][0][1] = faces[i][1][2];
        faces[i][0][2] = faces[i][2][2];
        faces[i][1][2] = faces[i][2][1];
        faces[i][2][2] = faces[i][2][0];
        faces[i][2][1] = faces[i][1][0];
        faces[i][2][0] = temp[0];
        faces[i][1][0] = temp[1];
        faces[i][0][0] = temp[2];
    }
    
    public boolean checkIfSolved ()
    {
        for (int i = 0; i < faces.length; i++)
        {
            for (int j = 0; j < faces[i].length; j++)
            {
                for (int m = 0; m < faces[i][j].length; m++)
                {
                    if (!solvedState[i][j][m].equals(faces[i][j][m]))
                        return false;
                }
            }
        }
        return true;
    }
    
    public void printCube()
    {
        System.out.println("\t\t\tTOP FACE:");
        for (int i = 0; i < faces[0].length; i++)
        {
            System.out.print("\t\t\t");
            for (int j = 0; j < faces[0][i].length; j++)
            {
                System.out.print(faces[0][i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("LEFT FACE:\t\tFRONT FACE:\t\tRIGHT FACE:\t\tBACK FACE:");
        for (int i = 0; i < faces[1].length; i++)
        {
            for (int j = 0; j < faces[1][i].length; j++)
            {
                System.out.print(faces[1][i][j] + "    ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < faces[1][i].length; j++)
            {
                System.out.print(faces[2][i][j] + "    ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < faces[1][i].length; j++)
            {
                System.out.print(faces[3][i][j] + "    ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < faces[1][i].length; j++)
            {
                System.out.print(faces[4][i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("\t\t\tBOTTOM FACE:");
        for (int i = 0; i < faces[0].length; i++)
        {
            System.out.print("\t\t\t");
            for (int j = 0; j < faces[0][i].length; j++)
            {
                System.out.print(faces[5][i][j] + "    ");
            }
            System.out.println();
        }
    }
}