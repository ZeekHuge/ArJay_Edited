
package com.wordpress.zubeentolani.arjayv010;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static com.wordpress.zubeentolani.arjayv010.R.id.detail_list_view_rwDetailTextView;


public class detail_list_class extends ArrayAdapter {

    final int resource;
    final Context context;
    ArrayList<frameObject> strings = new ArrayList<frameObject>();
    //    String[] strings ;


    public detail_list_class(Context context, int resource, ArrayList<frameObject> arrstring) {
        super(context, -1, arrstring);
        this.context = context;
        this.resource = resource;
        this.strings = arrstring;
    }






    @Override
    public View getView(final int n, View view, ViewGroup viewGroup) {

//        Log.i("AlertZeek","Getting view for ID="+MainActivity.supportedID3Frames[n]);
        final View rowView = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(this.resource, viewGroup, false);
        final LinearLayout linearLayout = (LinearLayout)rowView.findViewById(R.id.detail_list_view_topLinearLay);
        final TextView rwTextView = (TextView)rowView.findViewById(R.id.detail_list_view_rwTextView);
        final ImageView imageView = (ImageView)rowView.findViewById(R.id.detail_list_view_rwImageView);
        final TextView detailTextView = (TextView) rowView.findViewById(detail_list_view_rwDetailTextView);

        String parsedData = null;
        if(strings.get(n).frameID.compareTo("TXXX") == 0) {
            Log.i("AlertZeek", "Reading " + strings.get(n).frameID+ " frame");

            byte[] frameDescription = strings.get(n).frameDetail.getBytes();
            byte[][] bt = MainActivity.TXXX_seperate(frameDescription);
            if (bt == null){
                parsedData = "UnsupportedFormat";
            }
            else{
                parsedData = "Description:"+ MainActivity.textInformationParser(bt[0]) + " Values:" + MainActivity.textInformationParser(bt[1]);
            }
        }



        //rowView.setId(n);
//        Log.i("AlertZeek", "index = " + n + " name = " + strings.get(n).frameName + " id " + strings.get(n).frameID );
        imageView.setImageResource(imageView.getContext().getResources().getIdentifier("_" + strings.get(n).frameName.substring(0, 1).toLowerCase(), "drawable", imageView.getContext().getPackageName()));
//        Log.i("AlertZeek", "index = " + n + " id = " + strings.get(n).frameID);
        rwTextView.setText(strings.get(n).frameName);

        if (strings.get(n).framePosition == -1) {
            detailTextView.setText("This frame dose not exist in the file");
//            Log.i("AlertZeek", "1");
        } else if (strings.get(n).frameDetail == null){
            detailTextView.setText("Encoding unsupported(You can still change it)");
        }else if (strings.get(n).frameDetail.compareTo("") == 0) {
            detailTextView.setText("This frame is empty");
//            Log.i("AlertZeek", "2");

        }else{
            detailTextView.setText(strings.get(n).frameDetail);
//            Log.i("AlertZeek", "3");
        }

        if (parsedData != null){
            detailTextView.setText(parsedData);
        }
//        Log.i("AlertZeek","crossed = "+ n);


/*

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Log.i("AlertZeek", String.format("inside onClick of detail_list_class id=%d ", button.getId()));

                MainActivity.callDialogBox();





                if (strings.get(n).detailsVisible == false) {
                    Animation linearLayout_removeAnim = new TranslateAnimation(
                            Animation.RELATIVE_TO_SELF, 0.0f,
                            Animation.RELATIVE_TO_SELF, 0.0f,
                            Animation.RELATIVE_TO_SELF, 0.0f,
                            Animation.RELATIVE_TO_SELF, linearLayout.getY() + linearLayout.getHeight());
                    linearLayout_removeAnim.setDuration(500);

                    Animation anim_show = new AnimationUtils().loadAnimation(context, R.anim.edit_text_show);


                        //                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 0));
                    editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    editText.setMinHeight(60);
                    editText.setVisibility(View.VISIBLE);
                    linearLayout.startAnimation(linearLayout_removeAnim);
                    editText.startAnimation(anim_show);
                    strings.get(n).detailsVisible = true;
                }else {
                    Animation linearLayout_removeAnim = new TranslateAnimation(
                            Animation.RELATIVE_TO_SELF, 0.0f,
                            Animation.RELATIVE_TO_SELF, 0.0f,
                            Animation.RELATIVE_TO_SELF, linearLayout.getY() + linearLayout.getHeight(),
                            Animation.RELATIVE_TO_SELF, 0.0f);
                    linearLayout_removeAnim.setDuration(500);

                    Animation anim_show = new AnimationUtils().loadAnimation(context, R.anim.edit_text_show);


                        //                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 0));
                    editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                    editText.setMinHeight(0);
                    editText.setVisibility(View.VISIBLE);
                    linearLayout.startAnimation(linearLayout_removeAnim);
                    editText.startAnimation(anim_show);
                    strings.get(n).detailsVisible = false;

//                    editText.setFocusable(true);
//                    editText.setFocusableInTouchMode(true);

                }
            }
        });
*/
        /*
        if (strings.get(n).detailsVisible==true) {
            editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            editText.setMinHeight(60);
            editText.setVisibility(View.VISIBLE);
        }
        */
//



//                rowView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//                ((LinearLayout)lstVw[0].getParent()).addView(rowView);

//                FrameLayout fmLay = (FrameLayout) rowView.getParent().getParent();
//                Log.i("Function", String.format("id=%d", fmLay.getId()));
//                lstVw[0].removeView(rowView);
//                fmLay.addView(rowView);
//                MainActivity.buttonPressed_loadDetailView(rowView);


//                    lstVw[0] = (ListView) rowView.getParent();
//                    lstVw[0].smoothScrollByOffset(n - lstVw[0].getChildAt(0).getId());
//                    String[] tempStr = {strings[n]};
////                    button.setHeight(((LinearLayout) lstVw[0].getParent()).getHeight());
//                    Animation anim = AnimationUtils.loadAnimation(context,R.anim.show_details_anim);
//                    rwDetailTextView.startAnimation(anim);
////
//
//                    final customArrayAdapter tempAdap = new customArrayAdapter(context, resource, tempStr, 1);
//
//                    rowView.setLayoutParams(new LinearLayout.LayoutParams(lstVw[0].getWidth(),lstVw[0].getHeight()));
//                    lstVw[0].setLayoutParams(new LinearLayout.LayoutParams(0, 0));

//                    final android.os.Handler handler = new android.os.Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            lstVw[0].setAdapter(tempAdap);
//                        }
//                    },1000);
//

//                    rwDetailTextView.setVisibility(View.VISIBLE);
//                    rwDetailTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));


//                    lstVw.scrollBy(0, (int) rowView.getY());
//                    lstVw.scrollListBy(n);

//                    lstVw.scrol
//                    rwDetailTextView.scrollTo(1, 1);
//                    rwDetailTextView.scrollBy(50, 50);
//                    linearLayout.scrollTo(1, 1);
//                    linearLayout.scrollBy(50, 50);


//                    lstVw[0].smoothScrollByOffset(n - lstVw[0].getChildAt(0).getId());

//                    String[] tempStr = {"str"};
//
//                    customArrayAdapter tempAdap = new customArrayAdapter(context, resource, tempStr,0);
//                    lstVw[0].setAdapter(tempAdap);


        return rowView;
    }

}

