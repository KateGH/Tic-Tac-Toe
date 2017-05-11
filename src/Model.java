import java.util.Observable;/*    Comment from Oscar    1. let setClick() calls isFree() to minimise coding in class Controller    2. throws exception from Model to View since JOptionPane is suppose to show in View */// Model is OBSERVABLEpublic class Model extends Observable {    Mark [] cells = new Mark[9];    int position;    int numberOfClicks = 1;    Mark currentMark = Mark.X;    public Model(){    }    public boolean isFree(int position){        boolean XorO;        if(cells[position] == null){            XorO = true;                    // true means available/free to put X/O        }else {            XorO = false;        }//          System.out.println(cells[position]); // !!techniques to recheck value of suspicious coding        return XorO;    }    public void setClick(int position, Enum XO) throws Exception{            if (isFree(position)) {                System.out.println(isFree(position));                if (currentMark == Mark.X) {                    cells[position] = Mark.X;                } else                    cells[position] = Mark.O;                System.out.println("Model      => currentMark: " + currentMark);                numberOfClicks++;                setChanged();                notifyObservers(position);            } else {                throw new Exception();            }    }    public void changeTurn() {        if (currentMark == Mark.X) {            currentMark = Mark.O;        } else            currentMark = Mark.X;    }    public void resetModel() {        numberOfClicks = 0;        for(int i=0;i<9;i++){            cells[i] = null;        }    }    public int getResult(){ // 1 => X win, 2 => O win, 3 => par, 0 => no winner yet/playing        // Horizontal check        if((cells[0] == cells[1]) && (cells[1] == cells[2]) && (cells[2] == (Mark.X)))            return 1;        if((cells[0] == cells[1]) && (cells[1] == cells[2]) && (cells[2] == (Mark.O)))            return 2;        if((cells[3] == cells[4]) && (cells[4] == cells[5]) && (cells[5] == (Mark.X)))            return 1;        if((cells[3] == cells[4]) && (cells[4] == cells[5]) && (cells[5] == (Mark.O)))            return 2;        if((cells[6] == cells[7]) && (cells[7] == cells[8]) && (cells[8] == (Mark.X)))            return 1;        if((cells[6] == cells[7]) && (cells[7] == cells[8]) && (cells[8] == (Mark.O)))            return 2;        // Vertical check        if((cells[0] == cells[3]) && (cells[3] == cells[6]) && (cells[6] == (Mark.X)))            return 1;        if((cells[0] == cells[3]) && (cells[3] == cells[6]) && (cells[6] == (Mark.O)))            return 2;        if((cells[1] == cells[4]) && (cells[4] == cells[7]) && (cells[7] == (Mark.X)))            return 1;        if((cells[1] == cells[4]) && (cells[4] == cells[7]) && (cells[7] == (Mark.O)))            return 2;        if((cells[2] == cells[5]) && (cells[5] == cells[8]) && (cells[8] == (Mark.X)))            return 1;        if((cells[2] == cells[5]) && (cells[5] == cells[8]) && (cells[8] == (Mark.O)))            return 2;        // Diagonal check        if((cells[0] == cells[4]) && (cells[4] == cells[8]) && (cells[8] == (Mark.X)))            return 1;        if((cells[0] == cells[4]) && (cells[4] == cells[8]) && (cells[8] == (Mark.O)))            return 2;        if((cells[2] == cells[4]) && (cells[4] == cells[6]) && (cells[6] == (Mark.X)))            return 1;        if((cells[2] == cells[4]) && (cells[4] == cells[6]) && (cells[6] == (Mark.O)))            return 2;        if(numberOfClicks == 9)            return 3;           // No one wins this game        return 0;               // Playing    }}