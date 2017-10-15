package com.epam.Intro;

public class IntroTask6Note {

    private String bodyNote;
     private int idNote;
IntroTask6Note(int id){
    idNote=id;
    bodyNote="No notes";
}
    IntroTask6Note(int id, String body){
        idNote=id;
        bodyNote=body;
    }

    public IntroTask6Note(String bodyNote) {
        this.bodyNote = bodyNote;
    }

    int getIdNote(){
        return idNote;
    }

    public String getBodyNote() {
        return bodyNote;
    }

    public void setBodyNote(String bodyNote) {
        this.bodyNote = bodyNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IntroTask6Note other = (IntroTask6Note) obj;
        if (idNote != other.idNote)
            return false;
        if (!bodyNote.equals(other.bodyNote))
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = getBodyNote() != null ? getBodyNote().hashCode() : 0;
        result = 31 * result + getIdNote();
        return result;
    }
}
