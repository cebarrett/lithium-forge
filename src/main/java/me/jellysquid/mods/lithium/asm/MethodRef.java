package me.jellysquid.mods.lithium.asm;


import cpw.mods.modlauncher.api.INameMappingService;

import java.util.Objects;

public class MethodRef {
    public final String name, desc;

    public MethodRef(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * Creates a {@link MethodRef} using intermediary names which will be mapped to the appropriate method in the
     * current environment.
     *
     * @param name The intermediary name of the method
     * @param desc The type descriptor of the method
     */
    public static MethodRef intermediary(String name, String desc) {
        String methodName = NameUtil.deobfName(INameMappingService.Domain.METHOD, name);

        return new MethodRef(methodName, desc);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other != null && this.getClass() == other.getClass()) {
            MethodRef ref = (MethodRef) other;

            return Objects.equals(this.name, ref.name) && Objects.equals(this.desc, ref.desc);
        }

        return false;

    }

    @Override
    public int hashCode() {
        int h = this.name.hashCode();
        h = 31 * h + this.desc.hashCode();

        return h;
    }

    @Override
    public String toString() {
        return String.format("MethodRef{name='%s', desc='%s'}", this.name, this.desc);
    }
}
