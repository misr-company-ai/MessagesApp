package com.example.messagesapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val bundle = intent.extras
        if (bundle != null) {
            val pdus = bundle["pdus"] as Array<*>

            for (pdu in pdus) {
                val sms = SmsMessage.createFromPdu(pdu as ByteArray)
                val msg = sms.messageBody

                Toast.makeText(context, "رسالة جديدة: $msg", Toast.LENGTH_LONG).show()
            }
        }
    }
}
