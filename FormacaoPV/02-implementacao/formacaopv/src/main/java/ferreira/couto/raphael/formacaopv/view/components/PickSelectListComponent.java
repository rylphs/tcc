package ferreira.couto.raphael.formacaopv.view.components;

import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

@FacesComponent("ferreira.couto.raphael.pick-select")
public class PickSelectListComponent extends UINamingContainer {
	private Object toDelete;
	private Object selected;
	
	public void removeItem(){
		Object item = toDelete;
		getPickList().remove(item);
		getSelectList().add(item);
	}
	
	private List<Object> getPickList() {
		return (List<Object>) getAttributes().get("pickList");
	}
	
	private List<Object> getSelectList(){
		return (List<Object>) getAttributes().get("selectList");
	}

	public void addItem(){
		getPickList().add(selected);
		getSelectList().remove(selected);
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
		this.selected = selected;
	}
}
