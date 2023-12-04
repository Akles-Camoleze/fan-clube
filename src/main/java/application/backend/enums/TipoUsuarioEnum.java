package application.backend.enums;

public enum TipoUsuarioEnum {
    ADMIN(1, "Administrador"),
    COMUM(2, "Comum");

    private final int id;
    private final String descricao;

    TipoUsuarioEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoUsuarioEnum getById(int id) {
        for (TipoUsuarioEnum tipo : values()) {
            if (tipo.id == id) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("ID de Tipo inválido: " + id);
    }
}
