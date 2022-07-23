package com.gizcompony.prototype.models_adapters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Assistant {

    public static List<Complaint> getComplaints(){
        List<Complaint> complaints = new ArrayList<>();

        Calendar calendar = Calendar.getInstance() ;
        Date now = calendar.getTime() ;
        addToList(complaints ,
                new Complaint(now ,"إزعاج كلاب" , "يمر يوميا كلاب من منطقة التحلية عصرا و يكون الإزعاج عالي جدا" , "التحلية , معن ، مقابل شركة جعفر للبترول" , 0l , 0l) ,
                new Complaint(now ,"طفح صرف صحي" , "يوجد طفح صرف صحي في منطقة الزنة عند مسجد الأبرار و قد امتلئت الشوراع بالتلوث العالي" , "منطقة الزنة مسجد الأبرار" , 0l , 0l) ,
                new Complaint(now ,"شكوى بلا عنوان" , "هذه الشكوى فقط تجربة لل recycler ، بإذن الله لن نشكي همنا إلا له وحده عز و جل" , "الأندرويد ستديو كلاس ال Assistant" , 0l , 0l) ,
                new Complaint(now ,"رسالة للمبرمجة مريم العبادسة" , "رسالة للمبرمجة المميزة في كل المجالات مريم العبادسة .. أسأل الله أن يمن عليك بعلم كبير من عنده ،، و مبارك قبولك في مسابقة عنان . وإن شاء الله نراك في مراتب عليا ، المهم اشتغلي الكود الخاص بهذا التطبيق بشكل ممتاز كما اعتدنا عليكِ" , "من زميل عمل مجهول" , 0l , 0l) ,
                new Complaint(now ,"انهيار شارع" , "شارع جكر على حدود دولة غزة المحاصرة يعاني من انهيارات بسبب استمرار جرافات الاحتلال بالتجول بالقرب منه" , "على الشريط الحدودي لقطاع غزة" , 0l , 0l) ,
                new Complaint(now ,"لماذا نحن هنا" , "سؤال صعب سؤال صعب ، لماذا يعيش السمك في الماء ولماذا الاثنين قبل الثلاثاء" , "سبيستون ،، قناة شباب المستقبل" , 0l , 0l) ,
                new Complaint(now ,"هل لك سر عند الله" , "يا نجوما زينت ثوب الليالي ، احضنيني واعلمي سر انفعالي ، سأناجي الله ربي ذا الجلال ،، بخضوعي و خشوعي و سؤالي" , "الأحبال الصوتية للمنشد مش عارف ايش اسمه" , 0l , 0l) ,
                new Complaint(now ,"من غزة ينتصر الضيف" , "يا سيف القدس ولن تغلب ، ونسيم البحر له نهف ، ،يا سيف القدس و لن تغلب" , "" , 0l , 0l) ,
                new Complaint(now ,"أهل النفاق أصولهم مكشوفة" , " فسلول بالإوصاف كان مجسدا ، يتحدثون باسمنا لكنهم ، خانوا اله الكون خانوا قدسنا" , "الأحبال الصوتية لأحد المنشدين المفضلين لدي ، إبراهيم الأحمد" , 0l , 0l) ,
                new Complaint(now ,"هذه الشكوى فارغة" , "هذه الشكوى فارغة" , "بلا عنوان" , 0l , 0l)
                );
        return  complaints ;
    }


    public static <T> void addToList(List<T> list, T... ts) {
        for (T t : ts) {
            list.add(t);
        }
    }
    public static String formatDate(Date date) {
        String pattern = "yyyy/MM/dd" ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(date);
    }

}
