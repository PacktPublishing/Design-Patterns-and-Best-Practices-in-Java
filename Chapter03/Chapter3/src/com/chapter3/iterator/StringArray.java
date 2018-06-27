package com.chapter3.iterator;

public class StringArray implements Aggregate
{
    private String values[];
    
    public StringArray(String[] values) {
    	this.values = values; 
	}

    public Iterator createIterator()
    {
        return (Iterator) new StringArrayIterator();
    }


    private class StringArrayIterator implements Iterator
    {
    	private int position;

        public boolean hasNext()
        {
            return (position < values.length);
        }
        public String next()
        {
            if (this.hasNext())
                return values[position++];
            else
                return null;
        }
    }
}

