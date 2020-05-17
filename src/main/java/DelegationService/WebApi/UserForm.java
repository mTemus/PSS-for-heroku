package DelegationService.WebApi;

import DelegationService.Model.User;
import DelegationService.Model.Delegation;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

import java.util.List;

public class UserForm extends FormLayout {
    private IntegerField iduser = new IntegerField("ID");
    private PasswordField password = new PasswordField("New Password");
    private TextField name = new TextField("Name");
    private TextField lastName = new TextField("Last Name");
    private TextField email = new TextField("E-Mail");
    private TextField companyName = new TextField("Company Name");
    private TextField companyAddress = new TextField("Company Address");
    private TextField companyNip = new TextField("Company Nip");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    Button promoteAdmin = new Button("Promote Admin");
    Button demoteUser = new Button("Demote User");

    BeanValidationBinder<User> binder = new BeanValidationBinder<>(User.class);

    public UserForm(){
        binder.forField(iduser).bind("iduser");
        binder.forField(password).bind("password");
        binder.forField(name).bind("name");
        binder.forField(lastName).bind("lastName");
        binder.forField(email).bind("email");
        binder.forField(companyName).bind("companyName");
        binder.forField(companyAddress).bind("companyAddress");
        binder.forField(companyNip).bind("companyNip");
        binder.setBean(new User());

        add(iduser,
                companyName,
                companyAddress,
                companyNip,
                name,
                lastName,
                email,
                password,
                createButtonsLayout(),
                promoteAdmin,
                demoteUser);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, binder.getBean())));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));
        promoteAdmin.addClickListener(buttonClickEvent -> fireEvent(new MakeAdminEvent(this, binder.getBean())));
        demoteUser.addClickListener(buttonClickEvent -> fireEvent(new MakeUserEvent(this, binder.getBean())));


        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new SaveEvent(this, binder.getBean()));
        }
    }
    public void setUser(User user) {
        binder.setBean(user);
    }
    public static abstract class UserFormEvent extends ComponentEvent<UserForm> {
        private User user;

        protected UserFormEvent(UserForm source, User contact) {
            super(source, false);
            this.user = contact;
        }

        public User getUser() {
            return user;
        }
    }

    public static class SaveEvent extends UserFormEvent {
        SaveEvent(UserForm source, User contact) {
            super(source, contact);
        }
    }

    public static class DeleteEvent extends UserFormEvent {
        DeleteEvent(UserForm source, User user) {
            super(source, user);
        }

    }

    public static class CloseEvent extends UserFormEvent {
        CloseEvent(UserForm source) {
            super(source, null);
        }
    }

    public static class MakeAdminEvent extends  UserFormEvent {
        MakeAdminEvent(UserForm source, User user) {
            super(source, user);
        }
    }

    public static class MakeUserEvent extends UserFormEvent{
        MakeUserEvent(UserForm source, User user) {
            super(source, user);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}
