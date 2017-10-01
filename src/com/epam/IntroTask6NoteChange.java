package com.epam;
public class IntroTask6NoteChange {
    private static int idNotepad=0;
    private IntroTask6Note noteMas[];

    public IntroTask6NoteChange(int sizeNote) {
        this.noteMas= new IntroTask6Note[sizeNote];
    }
    void addNote(String body) {
        IntroTask6Note Note = new IntroTask6Note(idNotepad++);
        Note.setBodyNote(body);
        if (noteMas.length - 1 > idNotepad) {
            noteMas[Note.getIdNote()] = Note;
        } else System.out.println("NotePad is full!");
    }
    void deleteNote(int Id) {
           for (int i = 0; i < noteMas.length; i++) {
               if (noteMas[i].getIdNote() == Id) {
                   for (int j = i; j < idNotepad - 1; j++) {
                       //System.arraycopy();

                       noteMas[j] = noteMas[j + 1];
                   }
                   idNotepad--;
                   break;
               }

           }
       }
   // void changeNote(int id, String strChange){}
        void getNote(int idNote){
            System.out.println("Id: "+noteMas[idNote].getIdNote()+" Text:"+noteMas[idNote].getBodyNote());
        }
    void getAllNote(){
            for(int i=0;i<idNotepad;i++){
                System.out.println("Id: "+noteMas[i].getIdNote()+" Text:"+noteMas[i].getBodyNote());
            }
    }

}
