package com.example.gmailgui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter
    private lateinit var emailList: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Tạo danh sách email mẫu
        emailList = listOf(
            Email("Họp vào thứ 6", "john@example.com", "Chúng ta cần thảo luận về dự án."),
            Email("Tin tức mới", "news@daily.com", "Có một số cập nhật quan trọng."),
            Email("Lịch trình mới", "manager@company.com", "Đã cập nhật lịch trình cho tuần tới."),
            Email("Giảm giá lớn", "offers@store.com", "Chỉ hôm nay, giảm giá 50%!"),
            Email("Chúc mừng", "friend@example.com", "Chúc bạn một ngày vui vẻ!")
        )

        emailAdapter = EmailAdapter(emailList)
        recyclerView.adapter = emailAdapter
    }
}