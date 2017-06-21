package heap;

import java.util.PriorityQueue;

public class CommandHolderQueue 
{
	private PriorityQueue<Commands> commandQueue = new PriorityQueue<Commands>();
	
	public static void main(String[] args) 
	{
		Commands c1 = new Commands(System.currentTimeMillis());
		Commands c2 = new Commands(System.currentTimeMillis()+5L);
		Commands c3 = new Commands(System.currentTimeMillis()+6L);
		Commands c4 = new Commands(System.currentTimeMillis()+8L);
		Commands c5 = new Commands(System.currentTimeMillis()+1L);
		Commands c6 = new Commands(System.currentTimeMillis());
		Commands c7 = new Commands(System.currentTimeMillis()+10);
		
		CommandHolderQueue chq = new CommandHolderQueue();
		chq.addCommand(c1);
		chq.addCommand(c2);
		chq.addCommand(c3);
		chq.addCommand(c4);
		chq.addCommand(c5);
		chq.addCommand(c6);
		chq.addCommand(c7);
		
		
	}
	
	public void addCommand(Commands command)
	{
		commandQueue.add(command);
	}
	
	public Commands processCommand()
	{
		return commandQueue.remove();
	}
	
	public void updateCommandPriorities()
	{
		
	}
}
