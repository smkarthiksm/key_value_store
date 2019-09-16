package model;

public class KeyValueModel {
    private String key;
    private ValueModel valueModel;

    public KeyValueModel(String key, ValueModel valueModel) {
        this.key = key;
        this.valueModel = valueModel;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ValueModel getValueModel() {
        return valueModel;
    }

    public void setValueModel(ValueModel valueModel) {
        this.valueModel = valueModel;
    }

    @Override
    public String toString() {
        return "KeyValueModel{" +
                "key='" + key + '\'' +
                ", valueModel=" + valueModel +
                '}';
    }
}
