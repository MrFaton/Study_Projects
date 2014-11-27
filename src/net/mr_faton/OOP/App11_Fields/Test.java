package net.mr_faton.OOP.App11_Fields;

/**
 * Created by Faton on 27.11.2014.
 */
public class Test {
    public static void main(String[] args) {
        Child refChild = new Child();
        Parent refParent = refChild;

        refChild.field = 1;
        refParent.field = 2;

        System.out.println(refChild.field);
        System.out.println(refParent.field);
    }
}
/*
Вообще фактически мы имеем в классе Child 2 одинаковых поля field (его поле и поле предка), но такой проверки
во время выполнения не происходит это только для статического поля, поля, статического методода. Если мы обращаеся к
полю с типом refChild, то это его поле, если с типом refParent, то это его поле и всё равно, что эти обе ссылки
указывают на один экзепляр. То есть тут нет оверрайдинга, поэтому для каждой сслыки есть своё поле field. Пример того,
что нет виртуальности.
 */