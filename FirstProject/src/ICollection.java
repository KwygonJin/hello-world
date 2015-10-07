
public interface ICollection<Type> {
	public void push(Type element);
	public Type pop();
	public boolean isEmpty();
	public int getSize();
}
