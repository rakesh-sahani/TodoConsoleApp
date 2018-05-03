import java.util.*;

 class util {

     static  void item_creator(TodoList list)
    {
        System.out.println();
        System.out.println("==========Create Item Section");
        String title;
        String desc;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the title");
        title=sc.next();
        if(list.isduplicate(title))
        {
            System.out.printf("title can't be duplicate");
            return;
        }
        System.out.println("enter the description");
        desc=sc.next();
        TodoItem t=new TodoItem(title,desc);
        TodoList tl=new TodoList();
        list.addItem(t);

    }
     static void item_remover(TodoList l)
    {
        System.out.println();
        System.out.println("==========Delete Item Section");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the title of  item to remove");
        String title=sc.next();
        for(TodoItem item: l.get_list())
        {
            if(title.equals(item.getTitle()))
            {
                l.delete_item(item);
                break;

            }
        }




    }
     static void list_all(TodoList l)
    {
        for(TodoItem item: l.get_list())
        {
            System.out.println("Item Title: "+item.getTitle()+"  Item Description:  "+ item.getDesc());
        }



    }
     static void item_updater(TodoList l)
    {
        System.out.println();
        System.out.println("==========Edit Item Section");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the title of the item you want to update");
        String title=sc.next().trim();
        if(!l.isduplicate(title))
        {
            System.out.println("title does'nt exist");
            return;
        }

        System.out.println("enter the new title of the item");
        String new_title=sc.next().trim();
        if(l.isduplicate(new_title))
        {
            System.out.println("title can't be duplicate");
            return;
        }
        System.out.println("enter the new description ");
        String new_description=sc.next().trim();
        for(TodoItem item:l.get_list())
        {
            if(item.getTitle().equals(title))
            {
                int index=l.index_of(item);
                l.delete_item(item);
                TodoItem t=new TodoItem(new_title,new_description);
                l.addItem(t);
                System.out.println("item updated");
            }
        }




    }



}
