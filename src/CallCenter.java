import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CallCenter {
	
	private class employee{
		private boolean openLine;
		private int callsAnswered;
		
		public employee(boolean linestatus){
			openLine = linestatus;
			callsAnswered = 0;
		}
		
		public void changeOpenLine(){
			openLine = !openLine;
		}
		
		public int incrementCalls(){
			callsAnswered++;
			return callsAnswered;
		}
	}
	
	private class respondent extends employee{
		public respondent(boolean linestatus){
			super(linestatus);
		}
	}
	
	private class manager extends employee{
		public manager(boolean linestatus){
			super(linestatus);
		}
	}
	
	private class director extends employee{
		public director(boolean linestatus){
			super(linestatus);
		}
	}
	
	private static CallCenter _instance = null;
	protected CallCenter(){
		
	}
	public static CallCenter getInstance(){
		if(_instance == null){
			_instance = new CallCenter();
		}
		return _instance;
	}
	
	Queue<respondent> respondents = new LinkedList<respondent>();
	Queue<manager> managers = new LinkedList<manager>();
	Queue<director> directors = new LinkedList<director>();
	
	HashSet<respondent> busyResps = new HashSet<respondent>();
	HashSet<manager> busyMans = new HashSet<manager>();
	HashSet<director> busyDirs = new HashSet<director>();

	public void dispatchCall(){
		if(!respondents.isEmpty()){
			respondent newCall = respondents.remove();
			busyResps.add(newCall);
		}else if(!managers.isEmpty()){
			manager newCall = managers.remove();
			busyMans.add(newCall);
		}else if(!directors.isEmpty()){
			director newCall = directors.remove();
			busyDirs.add(newCall);
		}
	}
	
	public void queueEmployee(employee type){
		if(type instanceof respondent){
			respondents.add((respondent) type);
		}else if(type instanceof manager){
			managers.add((manager) type);
		}else if(type instanceof director){
			directors.add((director) type);
		}
	}
}
