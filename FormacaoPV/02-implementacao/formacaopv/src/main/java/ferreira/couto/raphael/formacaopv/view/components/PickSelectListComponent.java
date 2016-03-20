package ferreira.couto.raphael.formacaopv.view.components;

import java.io.IOException;
import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

@FacesComponent("ferreira.couto.raphael.pick-select")
public class PickSelectListComponent extends UINamingContainer {
	private Object toDelete;
	private Object selected;
	private List<Object> remainingItems;
	
	public void removeItem(){
		Object item = toDelete;
		getPickList().remove(item);
	}
	
	@Override
	public void encodeAll(FacesContext context) throws IOException {
	    setRemainingItems((List<Object>) getAttributes().get("completeList"));
	    for(Object item:getPickList()){
	    	getRemainingItems().remove(item);
	    }
	    super.encodeAll(context);
	}
	
	private List<Object> getPickList() {
		return (List<Object>) getAttributes().get("pickList");
	}

	public void addItem(){
		System.out.println("add: " + selected);
		getPickList().add(selected);
		getRemainingItems().remove(selected);
	}

	public Object getToDelete() {
		return toDelete;
	}

	public void setToDelete(Object toDelete) {
		this.toDelete = toDelete;
	}

	public Object getSelected() {
		return selected;
	}

	public void setSelected(Object selected) {
		System.out.println("selected: " + selected);
		this.selected = selected;
	}

	public List<Object> getRemainingItems() {
		return remainingItems;
	}

	public void setRemainingItems(List<Object> remainingItems) {
		this.remainingItems = remainingItems;
	}
}
