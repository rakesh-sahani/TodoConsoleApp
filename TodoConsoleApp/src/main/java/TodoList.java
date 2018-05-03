
import java.util.*;
class TodoList {
    private   List<TodoItem> l;

  TodoList()
  {
      this.l=new ArrayList<TodoItem>();
  }


  void addItem(TodoItem t)
  {
      l.add(t);
  }

  void delete_item(TodoItem t)
  {
      l.remove(t);
  }

  void edit_item(TodoItem t, TodoItem updated)
  {
      int index=l.indexOf(t);
      l.remove(index);
      l.add(updated);
  }

  ArrayList<TodoItem> get_list()
  {
      return new ArrayList<TodoItem>(l);
  }

  void sort_byname()
  {
      Collections.sort(l,new TodoSortByName());

  }
  void reverse_list()
  {
      Collections.reverse(l);
  }

  void sort_bydate()
  {
      Collections.sort(l,new TodoSortByDate());
  }

  void list_all()
  {
      System.out.println();
      System.out.println("inside list_All method");
      for(TodoItem myitem:l)
      {

            System.out.println(myitem.getTitle()+myitem.getDesc());
      }
    }

    int  index_of(TodoItem t)
    {
        return l.indexOf(t);
    }

    Boolean isduplicate(String  title)
    {
        for(TodoItem item:l)
        {
            if(title.equals(item.getTitle()))
            {
                return true;



            }

        }
        return false;
    }



}
