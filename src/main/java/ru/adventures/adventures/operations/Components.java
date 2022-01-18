package ru.adventures.adventures.operations;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.jetbrains.annotations.NotNull;

public class Components {
    public static @NotNull String LegacyString(TextComponent component) {
        return LegacyComponentSerializer.legacyAmpersand().serialize(component);
    }

    public static @NotNull String GsonString(TextComponent component) {
        return GsonComponentSerializer.gson().serialize(component);
    }

    public static @NotNull String PlainString(TextComponent component) {
        return PlainTextComponentSerializer.plainText().serialize(component);
    }

    public static @NotNull Component LegacyComponent(String string) {
        return  LegacyComponentSerializer.legacyAmpersand().deserialize(string);
    }

    public static @NotNull Component GsonComponent(String string) {
        return GsonComponentSerializer.gson().deserialize(string);
    }

    public static @NotNull Component PlainComponent(String string) {
        return PlainTextComponentSerializer.plainText().deserialize(string);
    }
}
