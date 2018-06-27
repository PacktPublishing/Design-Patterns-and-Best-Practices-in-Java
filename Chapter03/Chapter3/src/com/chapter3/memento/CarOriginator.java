package com.chapter3.memento;

public class CarOriginator {

    private String state;
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return this.state;
    }
    
    public Memento saveState() {
        return new Memento(this.state);
    }
 
    public void restoreState(Memento memento) {
        this.state = memento.getState();
    }
    
    /**
     * Memento class
     */
    public static class Memento {
        private final String state;

        public Memento(String state) {
            this.state = state;
        }

        private String getState() {
            return state;
        }
    }

}

