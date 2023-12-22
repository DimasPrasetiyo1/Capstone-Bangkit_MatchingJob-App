package com.yourbynn.matchingjob.view.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.yourbynn.matchingjob.R
import com.yourbynn.matchingjob.activity.WelcomeActivity
import com.yourbynn.matchingjob.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        settingsMenu()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun settingsMenu(){
        binding.profileSetting.setOnClickListener { view ->
            val popup = PopupMenu(requireContext(), view)
            popup.menuInflater.inflate(R.menu.settings_menu, popup.menu)

            popup.setOnMenuItemClickListener { menuItem: MenuItem ->
                when(menuItem.itemId){
                    R.id.menu_edit_profile ->{
                        startActivity(Intent(requireActivity(), EditProfileActivity::class.java))
                        true
                    }
                    R.id.menu_logout -> {
                        startActivity(Intent(requireActivity(), WelcomeActivity::class.java))
                        requireActivity().finish()
                        true
                    }
                    else -> false
                }
            }
            popup.setOnDismissListener { menu ->
                menu.dismiss()
            }
            popup.show()
        }
    }
}