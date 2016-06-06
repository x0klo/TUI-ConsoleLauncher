package ohi.andre.consolelauncher.commands.raw;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import java.util.List;

import ohi.andre.consolelauncher.R;
import ohi.andre.consolelauncher.commands.CommandAbstraction;
import ohi.andre.consolelauncher.commands.ExecInfo;
import ohi.andre.consolelauncher.tuils.Tuils;

public class contacts implements CommandAbstraction {

    @Override
    public String exec(ExecInfo info) {
        if (ContextCompat.checkSelfPermission(info.context, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            return info.res.getString(R.string.output_nopermissions);
        }

        List<String> contacts = info.contacts.listNamesAndNumbers();
        Tuils.addPrefix(contacts, "  ");
        Tuils.insertHeaders(contacts, false);
        return Tuils.toPlanString(contacts);
    }

    @Override
    public int helpRes() {
        return R.string.help_contacts;
    }

    @Override
    public int minArgs() {
        return 0;
    }

    @Override
    public int maxArgs() {
        return 0;
    }

    @Override
    public int[] argType() {
        return null;
    }

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public String[] parameters() {
        return null;
    }

    @Override
    public String onNotArgEnough(ExecInfo info, int nArgs) {
        return null;
    }

    @Override
    public int notFoundRes() {
        return 0;
    }

}
