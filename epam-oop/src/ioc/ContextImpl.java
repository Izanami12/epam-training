package ioc;

import console.ExitMenuItem;
import console.FilterTariffMenuItem;
import console.Menu;
import console.MenuItem;
import console.ShowTariffsMenuItem;
import console.ShowUsersMenuItem;

public class ContextImpl implements Context {
    
    @Override
    public Menu getMenu() {
        final Menu menu = new Menu();
        menu.add(1, getShowTariffsMenuItem());
        menu.add(2, getShowUsersMenuItem());
        menu.add(3, getFilterTariffMenuItem());
        menu.add(4, getExitMenuItem());
        return menu;
    }

    @Override
    public MenuItem getShowTariffsMenuItem() {
        return new ShowTariffsMenuItem();
    }
    
    @Override
    public MenuItem getShowUsersMenuItem() {
        return new ShowUsersMenuItem();
    }
    
    @Override
    public MenuItem getExitMenuItem() {
        return new ExitMenuItem();
    }

    @Override
    public MenuItem getFilterTariffMenuItem() {
        return new FilterTariffMenuItem();
    }

}
