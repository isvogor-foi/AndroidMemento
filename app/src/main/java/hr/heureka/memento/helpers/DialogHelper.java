package hr.heureka.memento.helpers;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;
import hr.heureka.memento.R;
import hr.heureka.memento.entities.DbCategory;
import hr.heureka.memento.entities.DbTask;

/**
 * Created by ivan on 5.7.2016..
 */
public class DialogHelper {

    private Context context;

    @Bind(R.id.dialogEditTaskName)
    EditText editTaskName;

    @Bind(R.id.dialogEditDate)
    EditText editDate;

    @Bind(R.id.dialogEditTime)
    EditText editTime;

    @Bind(R.id.dialogCategorySpinner)
    Spinner categorySpinner;

    Calendar selectedDate = Calendar.getInstance();

    public DialogHelper(Context context, View parentView) {
        this.context = context;
        ButterKnife.bind(this, parentView);

        populateSpinner();
    }

    private void populateSpinner(){
        List<String> spinnerStringItems = new ArrayList<>();

        // dohvatiti trenutne "demo" kategorije
        for(DbCategory category : DbCategory.getAll()){
            spinnerStringItems.add(category.getName());
        }

        // napraviti adapter koji string-ove dodjeljuje elementima spinnera
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                context, android.R.layout.simple_spinner_item, spinnerStringItems);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // postavi adapter
        categorySpinner.setAdapter(spinnerAdapter);
    }

    // prikaz dijaloga za odabir vremena
    @OnFocusChange(R.id.dialogEditTime)
    public void onEditTimeClick(View view, boolean hasFocus){
        if(!hasFocus) return;
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, onTimeSetListener,
                selectedDate.get(Calendar.HOUR_OF_DAY), selectedDate.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    // prikaz dijaloga za odabir datuma
    @OnFocusChange(R.id.dialogEditDate)
    public void onEditDateClick(View view, boolean hasFocus){
        if(!hasFocus) return;
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, onDateSetListener,
                selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    // dohvaćanje odabranog vremena
    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            selectedDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
            selectedDate.set(Calendar.MINUTE, minute);

            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            editTime.setText(df.format(selectedDate.getTime()));
        }
    };

    // dohvaćanje odabranog datuma
    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            selectedDate.set(Calendar.YEAR, year);
            selectedDate.set(Calendar.MONTH, monthOfYear);
            selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            editDate.setText(df.format(selectedDate.getTime()));
        }
    };

    public void save(){
        DbTask task = new DbTask();
        task.setName(editTaskName.getText().toString());
        task.setDueDate(selectedDate.getTime());
        String category = categorySpinner.getItemAtPosition(categorySpinner.getSelectedItemPosition()).toString();
        task.setCategory(DbCategory.getCategoryByName(category));
        task.save();
    }
}
